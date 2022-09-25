package com.example.tbc_course_26.ui.main

import androidx.lifecycle.ViewModel
import com.example.tbc_course_26.data.local.data.User
import com.example.tbc_course_26.domain.repository.UserRepository
import com.example.tbc_course_26.domain.usecase.AddUserUseCase
import com.example.tbc_course_26.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val addUserUseCase: AddUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _userFlow = MutableStateFlow<List<User>>(emptyList())
    val userFlow = _userFlow.asStateFlow()

    suspend fun addUser(user:User){
        addUserUseCase(user)
    }

    suspend fun getUser(){
        _userFlow.emit(getUserUseCase())
    }


}