package com.iago.guests.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iago.guests.constants.GuestConstants
import com.iago.guests.databinding.FragmentPresentBinding
import com.iago.guests.view.adapter.GuestAdapter
import com.iago.guests.view.listener.GuestListener
import com.iago.guests.viewmodel.GuestsViewModel

class PresentsFragment : Fragment() {
  
  private var _binding: FragmentPresentBinding? = null
  private val binding get() = _binding!!
  
  private lateinit var viewModel: GuestsViewModel
  private val adapter = GuestAdapter()
  
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
    
    viewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
    _binding = FragmentPresentBinding.inflate(inflater, container, false)
    
    binding.recyclerPresents.layoutManager = LinearLayoutManager(context)
    binding.recyclerPresents.adapter = adapter
    
    // Listener
    val listener = object : GuestListener {
      override fun onClick(id: Int) {
        val intent = Intent(context, GuestFormActivity::class.java)
        
        val bundle = Bundle()
        bundle.putInt(GuestConstants.GUEST.ID, id)
        
        intent.putExtras(bundle)
        startActivity(intent)
      }
      
      override fun onDelete(id: Int) {
        viewModel.delete(id)
        viewModel.load(GuestConstants.FILTER.PRESENT)
      }
    }
    
    // Cria os observadores
    observe()
    
    adapter.attachListener(listener)
    return binding.root
  }
  
  override fun onResume() {
    super.onResume()
    viewModel.load(GuestConstants.FILTER.PRESENT)
  }
  
  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
  
  private fun observe() {
    viewModel.guestList.observe(viewLifecycleOwner) {
      adapter.updateGuests(it)
    }
  }
  
}