package com.aurosaswat.mvvmroom

import androidx.lifecycle.LiveData

class QuoteRepository(val quoteDao: QuoteDao) {
//    THis Class will talk with our Database

    fun getQuotes():LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }

}