package com.iago.guests.viewmodel

import androidx.lifecycle.ViewModel
import com.iago.guests.repository.GuestRepository

class GuestFormViewModel : ViewModel() {
  
  private val repository = GuestRepository.getInstacen()
  
  
}