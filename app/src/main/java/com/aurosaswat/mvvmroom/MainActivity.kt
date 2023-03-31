package com.aurosaswat.mvvmroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aurosaswat.mvvmroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  var binding: ActivityMainBinding?=null
    private  var mainViewModel: MainViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao=QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository=QuoteRepository(dao)
        mainViewModel= ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel?.getQuotes()?.observe(this) {
            binding?.quotes = it.toString()
        }
        binding?.btnAddQuote!!.setOnClickListener {
            val quote=Quote(0,"This is Testing","Testing")
            mainViewModel!!.insertQuote(quote)
        }

    }
}