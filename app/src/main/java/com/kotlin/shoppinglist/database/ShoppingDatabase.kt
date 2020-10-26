package com.kotlin.shoppinglist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlin.shoppinglist.dao.ShoppingListDao
import com.kotlin.shoppinglist.model.ShoppingItem

@Database(
    entities = [ShoppingItem::class], version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingListDao

    companion object {
        // The @Volatile annotation is used to make sure only one thread at a time can use this instance of our database to avoid data integrity.
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()


        // operator + invoke is executed whenever the class it is placed to, ShoppingDatabase, is being used.
        // For example, whenever we write ShoppingDatabase(), this line of code will be executed.
        // synchronized make sure that no other threads will access this instance at the same time
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        // Creating database
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db"
            ).build()
    }

}