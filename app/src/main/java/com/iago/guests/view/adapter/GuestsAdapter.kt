package com.iago.guests.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iago.guests.databinding.RowGuestBinding
import com.iago.guests.model.GuestModel
import com.iago.guests.view.listener.OnGuestListener
import com.iago.guests.view.viewholder.GuestViewHolder

class GuestsAdapter : RecyclerView.Adapter<GuestViewHolder>() {
  
  companion object {
    var countCreate = 0
    var countBind = 0
  }
  
  private var guestList: List<GuestModel> = listOf()
  private lateinit var listener: OnGuestListener
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
    countCreate++
    val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return GuestViewHolder(item, listener)
  }
  
  override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
    countBind++
    holder.bind(guestList[position])
  }
  
  override fun getItemCount(): Int {
    return guestList.count()
  }
  
  fun updateGuests(list: List<GuestModel>) {
    guestList = list
    notifyDataSetChanged()
  }
  
  fun attachListener(guestListener: OnGuestListener){
    listener = guestListener
  }
  
}