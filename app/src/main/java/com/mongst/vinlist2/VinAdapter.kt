package com.mongst.vinlist2

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mongst.vinlist2.data.AppDatabase

class VinAdapter(val launchUpdateVin: (Int?) -> Unit) : RecyclerView.Adapter<VinAdapter.ViewHolder>() {

    val vins = db.vinDao().getAllVins()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.vin_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vins.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.updateView(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stringVin = itemView.findViewById<TextView>(R.id.string_vin)
        val notesVin = itemView.findViewById<TextView>(R.id.notes_vin)
        val divider = itemView.findViewById<View>(R.id.divider)


        fun updateView(position: Int) {
            stringVin.text = vins[position].stringVin
            notesVin.text = vins[position].notesVin
            itemView.setOnClickListener{launchUpdateVin(vins[position].id)}

        }
    }
}
