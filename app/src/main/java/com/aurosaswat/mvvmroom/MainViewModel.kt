package com.aurosaswat.mvvmroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 * ViewModel will interact with the Repository,
 * Repository will communicate with the external source ;)
 *
 * */
class MainViewModel(private val quoteRepository: QuoteRepository):ViewModel() {


    fun getQuotes():LiveData<List<Quote>>{
//        All the quotes which we will get , this method will provide and with the help of this we will pass it to views ;)
//        And this will passs to repository and repository will pass it further ;)
        return quoteRepository.getQuotes()
    }

    fun insertQuote(quote: Quote){
        viewModelScope.launch(Dispatchers.IO){
            quoteRepository.insertQuote(quote)
//            Now for this viewmodel we need a viewmodel factory ;)
        }

    }
}