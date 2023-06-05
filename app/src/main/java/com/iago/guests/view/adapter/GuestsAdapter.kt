package com.iago.guests.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iago.guests.databinding.RowGuestBinding
import com.iago.guests.model.GuestModel
import com.iago.guests.view.viewholder.GuestViewHolder

class GuestsAdapter : RecyclerView.Adapter<GuestViewHolder>() {
  
  private var guestList: List<GuestModel> = listOf()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
    val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return GuestViewHolder(item)
  }
  
  override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
    holder.bind(guestList[position])
  }
  
  override fun getItemCount(): Int {
    return guestList.count()
  }
  
  fun updateGuests(list: List<GuestModel>) {
    guestList = list
    notifyDataSetChanged()
  }
  
}