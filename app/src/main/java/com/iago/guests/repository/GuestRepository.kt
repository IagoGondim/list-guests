package com.iago.guests.repository

import android.content.Context
import com.iago.guests.GuestModel

class GuestRepository private constructor(context: Context) {
  
  private val guestDataBase = GuestDataBase(context)
  
  companion object {
    
    private lateinit var repository: GuestRepository
    
    
    fun getInstacen(context: Context): GuestRepository {
      if (Companion::repository.isInitialized) {
        repository = GuestRepository(context)
      }
      return repository
    }
  }
  
  fun insert() {
  
  }
  
  fun update() {
  
  }
  
}