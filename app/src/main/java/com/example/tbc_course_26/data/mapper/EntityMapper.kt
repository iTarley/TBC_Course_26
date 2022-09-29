package com.example.tbc_course_26.data.mapper

import com.example.tbc_course_26.data.source.local.entity.UserEntity
import com.example.tbc_course_26.domain.model.User

fun User.toEntity() = UserEntity(
    id = id,
    firstName = firstName,
    lastName = lastName
)
fun UserEntity.toModel() = User(
    id = id,
    firstName = firstName,
    lastName = lastName
)