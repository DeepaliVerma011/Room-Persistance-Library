package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    var name:String,
    var number:String,
    var address:String,
    var age:Int,
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L
)