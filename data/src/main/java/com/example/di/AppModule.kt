package com.example.di


import com.example.core.api.ApiDetails
import com.example.core.repositories.PeopleRepository
import com.example.core.repositories.PeopleRepositoryImpl
import com.example.core.repositories.RoomsRepository
import com.example.core.repositories.RoomsRepositoryImpl
import com.example.core.usecases.GetPeopleUseCase
import com.example.core.usecases.GetPeopleUseCaseImpl
import com.example.core.usecases.GetRoomsUseCase
import com.example.core.usecases.GetRoomsUseCaseImpl
import com.example.core.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // Gson Converter
    @Provides
    fun providesGson(): GsonConverterFactory = GsonConverterFactory.create()

    // Retrofit
    @Provides
    @Singleton
    fun providesRetrofit(gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gson)
            .build()
    }

    // ApiReference
    @Provides
    @Singleton
    fun providesApiReference(retrofit: Retrofit): ApiDetails = retrofit.create(ApiDetails::class.java)

    // Dispatchers.io
    @Provides
    @Singleton
    fun providesDispatchers(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun providePeopleRepository(impl: PeopleRepositoryImpl): PeopleRepository {
        return impl;
    }

    @Provides
    @Singleton
    fun provideRoomRepository(impl: RoomsRepositoryImpl): RoomsRepository {
        return impl;
    }

    // provides GetPeopleUseCase
    @Provides
    @Singleton
    fun provideGetPeopleUseCase(peopleRepository: PeopleRepository): GetPeopleUseCase =
        GetPeopleUseCaseImpl(peopleRepository)

    // provides GetRoomsUseCase
    @Provides
    @Singleton
    fun provideGetRoomsUseCase(roomsRepository: RoomsRepository): GetRoomsUseCase =
        GetRoomsUseCaseImpl(roomsRepository)
}