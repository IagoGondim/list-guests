package com.iago.guests.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.iago.guests.constants.DataBaseConstants
import com.iago.guests.model.GuestModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

//class GuestDataBase(
//  context: Context,
//) : SQLiteOpenHelper(context, NAME, null, VERSION) {

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {
  
  abstract fun guestDAO(): GuestDAO
  
  companion object {
    private lateinit var INSTANCE: GuestDatabase
    
    @OptIn(InternalCoroutinesApi::class)
    fun getDatabase(context: Context): GuestDatabase {
      if (!::INSTANCE.isInitialized) {
        synchronized(GuestDatabase::class) {
          INSTANCE = Room.databaseBuilder(context, GuestDatabase::class.java, "guestDB")
            .addMigrations(MIGRATION_1_2)
            .allowMainThreadQueries()
            .build()
        }
      }
      return INSTANCE
    }
    
    /**
     * Atualização de versão de banco de dados
     */
    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
      override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("DELETE FROM Guest")
      }
    }
    
  }
}