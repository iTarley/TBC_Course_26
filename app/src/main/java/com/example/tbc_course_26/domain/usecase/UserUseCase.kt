package com.example.tbc_course_26.domain.usecase

data class UserUseCase(
    val getUser: GetUserUseCase,
    val addUser : AddUserUseCase,
    val deleteUser: DeleteUserUseCase
)
