package com.example.tbc_course_26.domain.usecase

import com.example.tbc_course_26.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository){

    suspend operator fun invoke() = userRepository.getAllUsers()
}