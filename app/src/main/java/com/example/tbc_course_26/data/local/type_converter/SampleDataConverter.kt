package com.example.tbc_course_26.data.local.type_converter

import androidx.room.TypeConverter
import java.util.*

class SampleDataConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}