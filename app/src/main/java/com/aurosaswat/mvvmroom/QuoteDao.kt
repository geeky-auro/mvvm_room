package com.aurosaswat.mvvmroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aurosaswat.mvvmroom.Quote

@Dao
interface QuoteDao {
    /**
     *
     * All the methods needs to be executed in background thread ;)
     * So Mark it as Suspend
     * */

//    All the CRUD Methods need to be defined here
    @Query("SELECT * FROM quote")
    fun getQuotes():LiveData<List<Quote>>
//        THis function will return all the quotes ;)


    @Insert
    suspend fun insertQuote(quote: Quote)


}