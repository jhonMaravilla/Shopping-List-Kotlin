package com.kotlin.shoppinglist.repository

import com.kotlin.shoppinglist.database.ShoppingDatabase
import com.kotlin.shoppinglist.model.ShoppingItem

class ShoppingListRepository(
    private val db: ShoppingDatabase
) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}