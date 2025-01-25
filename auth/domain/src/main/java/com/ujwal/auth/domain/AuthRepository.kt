package com.ujwal.auth.domain

import com.ujwal.core.domain.util.DataError
import com.ujwal.core.domain.util.EmptyResult

interface AuthRepository {

    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>

    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}