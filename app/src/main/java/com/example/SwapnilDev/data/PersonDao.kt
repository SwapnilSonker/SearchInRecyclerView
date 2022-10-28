package com.example.SwapnilDev.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.concurrent.Flow

@Dao
interface PersonDao {

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readData():kotlinx.coroutines.flow.Flow<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserData(person: Person)

    @Query("SELECT * FROM person_table WHERE firstname LIKE:searchQuery OR lastname LIKE:searchQuery")
    fun searchDatabase(searchQuery: String) : kotlinx.coroutines.flow.Flow<List<Person>>
}