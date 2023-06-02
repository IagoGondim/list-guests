package com.iago.guests.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.iago.guests.R
import com.iago.guests.databinding.ActivityGuestFormBinding
import com.iago.guests.model.GuestModel
import com.iago.guests.viewmodel.GuestFormViewModel


class GuestFormActivity : AppCompatActivity(), View.OnClickListener {
  
  private lateinit var binding: ActivityGuestFormBinding
  private lateinit var viewModel: GuestFormViewModel
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    binding = ActivityGuestFormBinding.inflate(layoutInflater)
    setContentView(binding.root)
  
    viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
    
    binding.buttonSave.setOnClickListener(this)
    binding.radioPresent.isChecked = true
  }
  
  override fun onClick(view: View) {
    if (view.id == R.id.button_save) {
      val name = binding.editName.text.toString()
      val presence = binding.radioPresent.isChecked
      
      val model = GuestModel(0, name, presence)
      viewModel.insert(model)
    }
  }
}