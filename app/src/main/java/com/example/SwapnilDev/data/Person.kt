package com.example.SwapnilDev.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    var firstname: String,
    var lastname: String,
    var age: Int
) {



    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}