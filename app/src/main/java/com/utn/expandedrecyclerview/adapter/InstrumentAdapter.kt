package com.utn.expandedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utn.expandedrecyclerview.R
import com.utn.expandedrecyclerview.entities.Instrument

class InstrumentAdapter (var instrumentList : MutableList<Instrument>) : RecyclerView.Adapter<InstrumentAdapter.InstrumentHolder>() {

    class InstrumentHolder (v : View) : RecyclerView.ViewHolder(v) {
        private var view : View
        init {
            this.view = v
        }

        fun setName (name : String){
            var txtName : TextView = view.findViewById(R.id.txtName)
            txtName.text = name
        }

        fun setBrand (brand : String){
            var txtBrand : TextView = view.findViewById(R.id.txtBrand)
            txtBrand.text = brand
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstrumentHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_instrument,parent,false)
        return (InstrumentHolder(view))
    }

    override fun onBindViewHolder(holder: InstrumentHolder, position: Int) {
        holder.setName(instrumentList[position].name)
        holder.setBrand(instrumentList[position].brand)

    }

    override fun getItemCount(): Int {
        return instrumentList.size
    }

}