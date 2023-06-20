package com.iago.guests.repository

import android.content.Context
import com.iago.guests.model.GuestModel

class GuestRepository(context: Context) {
  
  private val dataBase = GuestDatabase.getDatabase(context).guestDAO()
  
  
  fun save(guest: GuestModel): Boolean {
    return dataBase.save(guest) > 0
  }
  
  fun update(guest: GuestModel): Boolean {
    return dataBase.update(guest) > 0
  }
  
  fun delete(guest: GuestModel) {
    dataBase.delete(guest)
  }
  
  fun getAll(): List<GuestModel> {
    return dataBase.getAll()
  }
  
  fun get(id: Int): GuestModel {
    return dataBase.get(id)
  }
  
  fun getPresent(): List<GuestModel> {
    return dataBase.getPresent()
  }
  
  fun getAbsent(): List<GuestModel> {
    return dataBase.getAbsent()
  }
  
}