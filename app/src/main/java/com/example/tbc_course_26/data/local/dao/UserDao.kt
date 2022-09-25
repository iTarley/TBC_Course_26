package com.example.tbc_course_26.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tbc_course_26.data.local.data.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(vararg users: User)

}