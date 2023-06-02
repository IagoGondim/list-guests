package com.iago.guests.repository

import android.content.ContentValues
import android.content.Context
import com.iago.guests.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context) {
  
  private val guestDataBase = GuestDataBase(context)
  
  companion object {
    
    private lateinit var repository: GuestRepository
    
    fun getInstance(context: Context): GuestRepository {
      if (!::repository.isInitialized) {
        repository = GuestRepository(context)
      }
      return repository
    }
  }
  
  fun insert(guest: GuestModel): Boolean {
    return try {
      val db = guestDataBase.writableDatabase
      val presence = if (guest.presence) 1 else 0
      
      val values = ContentValues()
      values.put("name", guest.name)
      values.put("presence", presence)
      
      db.insert("Guest", null, values)
      true
    } catch (e: Exception) {
      
      false
    }
  }
  
  fun update() {
  
  }
  
}