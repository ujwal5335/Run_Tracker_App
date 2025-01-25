package com.ujwal.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ujwal.auth.domain.AuthRepository
import com.ujwal.auth.domain.UserDataValidator
import com.ujwal.auth.presentation.R
import com.ujwal.auth.presentation.textAsFlow
import com.ujwal.core.domain.util.DataError
import com.ujwal.core.domain.util.Result
import com.ujwal.core.presentation.ui.UiText
import com.ujwal.core.presentation.ui.asUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    private val eventChannel = Channel<RegisterEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        state.email.textAsFlow().onEach { email ->
            val isValidEmail = userDataValidator.isValidEmail(email.toString())
            state = state.copy(
                isEmailValid = isValidEmail,
                canRegister = isValidEmail && state.passwordValidationState.isPasswordValid && !state.isRegistering
            )
        }
            .launchIn(viewModelScope)

        state.password.textAsFlow().onEach { password ->
            val passwordValidationState = userDataValidator.validatePassword(password.toString())
            state = state.copy(
                passwordValidationState = passwordValidationState,
                canRegister = state.isEmailValid && passwordValidationState.isPasswordValid && !state.isRegistering

            )
        }
            .launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {
        when(action){
            RegisterAction.OnRegisterClick -> register()
            RegisterAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }
            else -> Unit
        }
    }

    private fun register() {
        viewModelScope.launch {
            state = state.copy(isRegistering = true)
            val result = authRepository.register(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isRegistering = false)

            when (result) {
                is Result.Error -> {
                    if (result.error == DataError.Network.CONFLICT) {
                        eventChannel.send(
                            RegisterEvent.Error(
                                UiText.StringResource(R.string.error_email_exists)
                            )
                        )
                    } else {
                        eventChannel.send(RegisterEvent.Error(result.error.asUiText()))
                    }
                }

                is Result.Success -> {
                    eventChannel.send(RegisterEvent.RegistrationSuccess)
                }
            }
        }
    }
}