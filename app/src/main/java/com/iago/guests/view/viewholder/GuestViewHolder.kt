package com.iago.guests.view.viewholder

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iago.guests.R
import com.iago.guests.databinding.RowGuestBinding
import com.iago.guests.model.GuestModel

class GuestViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {
  
  fun bind(guest: GuestModel) {
    bind.textName.text = guest.name
    
  }
  
}