package com.example.tbc_course_26.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tbc_course_26.data.source.local.dao.UserDao
import com.example.tbc_course_26.data.source.local.entity.UserEntity
import com.example.tbc_course_26.domain.model.User

@Database(entities = [UserEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}