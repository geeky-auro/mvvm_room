package com.aurosaswat.mvvmroom

import androidx.room.Entity
import androidx.room.PrimaryKey

//Mark it as an Entity becoz our db is an Entity and set tableName as Quote
@Entity(tableName = "quote")
data class Quote (
//    Make ID primary Key ;) and set it True for AUto Increment
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String,
    val author:String
    )