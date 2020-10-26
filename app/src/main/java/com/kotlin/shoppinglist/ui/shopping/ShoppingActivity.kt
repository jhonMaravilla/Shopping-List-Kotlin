package com.kotlin.shoppinglist.ui.shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kotlin.shoppinglist.R
import com.kotlin.shoppinglist.database.ShoppingDatabase
import com.kotlin.shoppinglist.repository.ShoppingListRepository

class ShoppingActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var database: ShoppingDatabase
    private lateinit var repository: ShoppingListRepository
    private lateinit var factory: ShoppingViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        database = ShoppingDatabase(this)
        repository = ShoppingListRepository(database)
        factory = ShoppingViewModelFactory(repository = repository)

        viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}