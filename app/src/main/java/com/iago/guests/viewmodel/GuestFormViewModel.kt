package com.iago.guests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.iago.guests.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {
  
  private val repository = GuestRepository.getInstacen(application)
  
  
}