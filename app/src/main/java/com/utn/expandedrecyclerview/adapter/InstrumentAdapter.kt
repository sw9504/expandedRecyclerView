package com.utn.myrecyclerview.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utn.expandedrecyclerview.R
import com.utn.expandedrecyclerview.entities.Instrument

class InstrumentAdapter(private var instrumentList : MutableList <Instrument>,
                        private var onClick : (Int) -> Unit) : RecyclerView.Adapter<InstrumentAdapter.InstrumentHolder> (){

    class InstrumentHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
        }

        fun setName (name : String) {
            var txtName : TextView = view.findViewById(R.id.txtName)
            txtName.text = name
        }

        fun setBrand (brand : String) {
            var txtBrand : TextView = view.findViewById(R.id.txtBrand)
            txtBrand.text = brand
        }

        fun getCard () : CardView {
            return view.findViewById(R.id.cardInstrument)
        }

        fun setImg () {
            var img : ImageView = view.findViewById((R.id.imgCircle))
            var imgUrl = "https://static.rfstat.com/logo-presets/2257/thumbnail_43e1fd8969ec_1x.webp"

                Glide.with(view)
                .load(imgUrl)
                .circleCrop()
                .into(img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstrumentHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_instrument,parent,false)
        return (InstrumentHolder(view))
    }

    override fun onBindViewHolder(holder: InstrumentHolder, position: Int) {
        holder.setName(instrumentList[position].name)
        holder.setBrand(instrumentList[position].brand)
        holder.setImg() // Uso una sola imagen harcodeada.
        holder.getCard().setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return instrumentList.size
    }
}

