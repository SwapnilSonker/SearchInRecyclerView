package com.example.SwapnilDev.data

import androidx.lifecycle.LiveData
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val personDao: PersonDao) {

    fun readData(): Flow<List<Person>> {
        return personDao.readData()
    }

    suspend fun insertData(person: Person)
    {
        return personDao.inserData(person)
    }

    fun searchDatabase(searchQuery: String): Flow<List<Person>> {
        return personDao.searchDatabase(searchQuery)
    }
}