package com.iago.guests.repository

class GuestRepository private constructor() {
  
  companion object {
    
    private lateinit var repository: GuestRepository
    
    
    fun getInstacen(): GuestRepository {
      if (Companion::repository.isInitialized) {
        repository = GuestRepository()
      }
      return repository
    }
  }
  
  fun save() {
  }
  
}