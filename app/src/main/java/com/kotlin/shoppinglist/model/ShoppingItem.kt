package com.kotlin.shoppinglist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem (

    @ColumnInfo(name = "item_name")
    var name: String,

    @ColumnInfo(name = "item_amount")
    var amount: Int
) {

    // We place it here so that when we create an object here, we dont need to add this to our constructor
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}