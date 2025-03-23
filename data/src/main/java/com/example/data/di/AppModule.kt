package com.example.data.di


import com.example.data.api.ApiDetails
import com.example.domain.repositories.GetPeopleUseCase
import com.example.domain.repositories.GetRoomsUseCase
import com.example.domain.usecases.GetPeopleUseCaseImpl
import com.example.domain.usecases.GetRoomsUseCaseImpl
import com.example.domain.utils.Constants.BASE_URL
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

    //Gson Converter
    fun providesGson() : GsonConverterFactory = GsonConverterFactory.create()

    //Retrofit
    @Provides
    @Singleton
    fun providesRetrofit(
        gson: GsonConverterFactory
    ): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gson)
            .build()
    }

    //ApiReference
    @Provides
    @Singleton
    fun providesApiReference(
        retrofit: Retrofit
    ) : ApiDetails = retrofit.create(ApiDetails::class.java)

    //Dispatchers.io
    @Provides
    @Singleton
    fun providesDispatchers() : CoroutineDispatcher = Dispatchers.IO

    //provides GetPeopleUseCase
    @Provides
    @Singleton
    fun provideGetPeopleUseCase(getPeopleUseCase: GetPeopleUseCase): GetPeopleUseCase = GetPeopleUseCaseImpl(getPeopleUseCase)

   //provides GetRoomsUseCase
    @Provides
    @Singleton
    fun provideGetRoomsUseCase(getRoomsUseCase: GetRoomsUseCase): GetRoomsUseCase = GetRoomsUseCaseImpl(getRoomsUseCase)





}