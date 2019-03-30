package com.mongst.vinlist2

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

internal class VinAdapter(private val vins: List<Vin>) : RecyclerView.Adapter<VinAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VinAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.vin_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VinAdapter.ViewHolder, position: Int) {
        holder.createVin.text = vins[position].createVin
        holder.notesVin.text = vins[position].notesVin
    }

    override fun getItemCount(): Int {
        return vins.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var createVin: TextView
        var notesVin: TextView

        init {
            createVin = itemView.findViewById(R.id.enter_vin)
            notesVin = itemView.findViewById(R.id.notes_vin)
        }
    }

}
