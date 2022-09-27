package com.example.tbc_course_26.data.local.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tbc_course_26.domain.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}