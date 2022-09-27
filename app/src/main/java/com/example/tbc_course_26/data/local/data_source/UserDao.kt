package com.example.tbc_course_26.data.local.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tbc_course_26.domain.model.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAll(): Flow<List<User>>

    @Insert
    suspend fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

}