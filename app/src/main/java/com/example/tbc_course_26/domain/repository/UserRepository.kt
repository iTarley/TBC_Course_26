package com.example.tbc_course_26.domain.repository

import com.example.tbc_course_26.data.local.data.User


interface UserRepository {

    suspend fun getAllUsers(): List<User>

    suspend fun addUser(user:User)
}