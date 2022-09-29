package com.example.tbc_course_26.data.local

import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import com.example.tbc_course_26.data.local.dao.UserDao
import com.example.tbc_course_26.data.local.entity.UserEntity
import com.example.tbc_course_26.data.local.type_converter.SampleDataConverter


@TypeConverters(value = [SampleDataConverter::class])
@Database(
    entities = [UserEntity::class],
    version = 4,
    autoMigrations = [
        AutoMigration (
            from = 3,
            to = 4,
            spec = AppDatabase.AutoMigrator::class
        )
    ]
)
abstract class AppDatabase : RoomDatabase() {

    @RenameTable(fromTableName = "user_table", toTableName = "renamed_table")
    class AutoMigrator:AutoMigrationSpec

    abstract fun userDao(): UserDao
}