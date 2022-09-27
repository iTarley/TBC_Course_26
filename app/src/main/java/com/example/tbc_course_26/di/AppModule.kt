package com.example.tbc_course_26.di

import com.example.tbc_course_26.domain.repository.UserRepository
import com.example.tbc_course_26.domain.usecase.AddUserUseCase
import com.example.tbc_course_26.domain.usecase.DeleteUserUseCase
import com.example.tbc_course_26.domain.usecase.GetUserUseCase
import com.example.tbc_course_26.domain.usecase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: UserRepository): UserUseCase {
        return UserUseCase(
            getUser = GetUserUseCase(repository),
            addUser = AddUserUseCase(repository),
            deleteUser = DeleteUserUseCase(repository)
        )
    }
}