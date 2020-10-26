package com.kotlin.shoppinglist.ui.shopping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.shoppinglist.repository.ShoppingListRepository

class ShoppingViewModelFactory(
    private val repository: ShoppingListRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}