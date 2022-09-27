package com.example.tbc_course_26.domain.usecase

import com.example.tbc_course_26.domain.model.User
import com.example.tbc_course_26.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository){

    operator fun invoke(): Flow<List<User>> {

        return userRepository.getAllUsers()

    }

}