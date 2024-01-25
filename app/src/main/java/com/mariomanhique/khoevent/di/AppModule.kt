package com.mariomanhique.khoevent.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.mariomanhique.khoevent.data.repository.userDataRepository.UserPreferencesSerializer
import com.mariomanhique.khoevent.data.repository.userDataRepository.UserDataRepository
import com.mariomanhique.khoevent.data.repository.userDataRepository.UserDataRepositoryImpl
import com.mariomanhique.khoevent.model.UserPreferences
import com.mariomanhique.khoevent.network.KhoEventsApi
import com.mariomanhique.khoevent.network.TokenInterceptor
import com.mariomanhique.khoevent.utils.ApplicationScope
import com.mariomanhique.khoevent.utils.Constants
import com.mariomanhique.khoevent.utils.Dispatcher
import com.mariomanhique.khoevent.utils.NiaDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(tokenInterceptor)
            .build()
    }

//    @Singleton
//    @Provides
//    fun provideTokenInterceptor(tokenInterceptor: TokenInterceptor): TokenInterceptor {
//        return tokenInterceptor
//    }


    @Singleton
    @Provides
    fun provideKhoEventsAPI(okHttpClient: OkHttpClient): KhoEventsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(KhoEventsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesUserPreferencesDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(NiaDispatchers.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        userPreferencesSerializer: UserPreferencesSerializer,
    ): DataStore<UserPreferences> =
        DataStoreFactory.create(
            serializer = userPreferencesSerializer,
            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
//            migrations = listOf(
//                IntToStringIdsMigration,
//            ),
        ) {
            context.dataStoreFile("user_preferences.json")
        }

    @Singleton
    @Provides
    fun provideUerDataRepository(
        userDataRepository: UserDataRepositoryImpl
    ): UserDataRepository {
        return userDataRepository
    }

}