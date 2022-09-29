package com.example.tbc_course_26.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tbc_course_26.data.local.entity.UserEntity
import com.example.tbc_course_26.domain.model.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM renamed_table")
    fun getAll(): Flow<List<UserEntity>>

    @Insert
    suspend fun insertAll(vararg users: UserEntity)

    @Delete
    fun delete(user: UserEntity)

}