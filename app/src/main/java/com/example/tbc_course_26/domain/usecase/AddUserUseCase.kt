package com.example.tbc_course_26.domain.usecase

import com.example.tbc_course_26.data.local.data.User
import com.example.tbc_course_26.domain.repository.UserRepository
import javax.inject.Inject

class AddUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(user: User) = userRepository.addUser(user)
}