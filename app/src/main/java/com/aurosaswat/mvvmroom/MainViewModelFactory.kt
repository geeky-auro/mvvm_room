package com.aurosaswat.mvvmroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val quoteRepository: QuoteRepository):ViewModelProvider.Factory {
//    Auto generated ;)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }

}