package com.kotlin.shoppinglist.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kotlin.shoppinglist.model.ShoppingItem

@Dao
interface ShoppingListDao {

    // Inserts the item if not in the table, but replaces or update it when it is
    // suspend function so we can execute it asynchronously
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    // suspend function so we can execute it asynchronously
    @Delete
    suspend fun delete(item: ShoppingItem)

    // Query everything in our table
    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}