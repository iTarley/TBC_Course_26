package com.example.tbc_course_26.domain.usecase

import com.example.tbc_course_26.domain.model.User
import com.example.tbc_course_26.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(user: User) = userRepository.deleteUser(user)
}