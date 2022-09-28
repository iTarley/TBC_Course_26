package com.example.tbc_course_26.domain.repository

import com.example.tbc_course_26.data.source.local.entity.UserEntity
import com.example.tbc_course_26.domain.model.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {

    fun getAllUsers(): Flow<List<UserEntity>>

    suspend fun addUser(user: User)

    suspend fun deleteUser(user:User)
}