package com.example.SwapnilDev.viewmodel

import androidx.lifecycle.*
import com.example.SwapnilDev.data.Person
import com.example.SwapnilDev.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val readData = repository.readData().asLiveData()

    fun insertData(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(person)
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Person>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }

}