package com.example.tbc_course_26.data.repository

import com.example.tbc_course_26.data.mapper.toEntity
import com.example.tbc_course_26.data.source.local.AppDatabase
import com.example.tbc_course_26.data.source.local.entity.UserEntity
import com.example.tbc_course_26.domain.model.User
import com.example.tbc_course_26.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow


import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val db: AppDatabase):UserRepository {

    override fun getAllUsers(): Flow<List<User>> {
       return db.userDao().getAll()
    }

    override suspend fun addUser(user: User) {
        db.userDao().insertAll(user.toEntity())
    }

    override suspend fun deleteUser(user: User) {
        db.userDao().delete(user.toEntity())
    }
}