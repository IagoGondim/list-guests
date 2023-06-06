package com.iago.guests.view.viewholder

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iago.guests.R
import com.iago.guests.databinding.RowGuestBinding
import com.iago.guests.model.GuestModel
import com.iago.guests.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
  RecyclerView.ViewHolder(bind.root) {
  
  fun bind(guest: GuestModel) {
    bind.textName.text = guest.name
    
    bind.textName.setOnClickListener {
      listener.onClick(guest.id)
    }
    
  }
  
}