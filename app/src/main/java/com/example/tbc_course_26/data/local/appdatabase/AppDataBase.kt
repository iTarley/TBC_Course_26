package com.example.tbc_course_26.data.local.appdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tbc_course_26.data.local.dao.UserDao
import com.example.tbc_course_26.data.local.data.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}