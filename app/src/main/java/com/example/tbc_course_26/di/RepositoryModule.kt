package com.example.tbc_course_26.di

import com.example.tbc_course_26.data.repository.UserRepositoryImpl
import com.example.tbc_course_26.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCourseRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}