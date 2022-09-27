package com.example.tbc_course_26.ui.main

import androidx.lifecycle.ViewModel
import com.example.tbc_course_26.domain.model.User
import com.example.tbc_course_26.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {


    suspend fun addUser(user: User) {
        withContext(Dispatchers.IO){
            userUseCase.addUser(user)
        }
    }

    suspend fun deleteUser(user:User){

        withContext(Dispatchers.IO){
            userUseCase.deleteUser(user)
        }

    }


    fun getUser(): Flow<List<User>> = userUseCase.getUser.invoke()


}