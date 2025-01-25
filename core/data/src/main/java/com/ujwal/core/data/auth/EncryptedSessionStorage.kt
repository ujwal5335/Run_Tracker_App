package com.ujwal.core.data.auth

import android.content.SharedPreferences
import com.ujwal.core.domain.AuthInfo
import com.ujwal.core.domain.SessionStorage
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class EncryptedSessionStorage(
    private val sharedPreferences: SharedPreferences
) : SessionStorage {
    override suspend fun get(): AuthInfo? {
        return withContext(IO) {
            val json = sharedPreferences.getString(KEY_AUTH_INFO, null)
            json?.let {
                Json.decodeFromString<AuthInfoSerializable>(it).toAuthInfo()
            }
        }
    }

    override suspend fun set(authInfo: AuthInfo?) {
        withContext(IO) {
            if (authInfo == null) {
                sharedPreferences.edit().remove(KEY_AUTH_INFO).commit()
                return@withContext
            }
            val json = Json.encodeToString(authInfo.toAuthInfoSerializable())
            sharedPreferences.edit().putString(KEY_AUTH_INFO, json).commit()
        }
    }

    companion object {
        private const val KEY_AUTH_INFO = "KEY_AUTH_INFO"
    }
}