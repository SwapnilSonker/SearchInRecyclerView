package com.example.SwapnilDev.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.SwapnilDev.data.PersonDao
import com.example.SwapnilDev.data.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PersonDatabase::class.java,
        "person_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: PersonDatabase) = database.personDao()
}