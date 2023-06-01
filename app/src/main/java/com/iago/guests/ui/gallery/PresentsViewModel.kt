package com.iago.guests.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentsViewModel : ViewModel() {
  
  private val _text = MutableLiveData<String>().apply {
    value = "This is presents Fragment"
  }
  val text: LiveData<String> = _text
}