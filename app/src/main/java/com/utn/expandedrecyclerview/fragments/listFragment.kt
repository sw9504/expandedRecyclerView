package com.utn.expandedrecyclerview.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utn.expandedrecyclerview.R
import com.utn.expandedrecyclerview.entities.Instrument
import com.utn.myrecyclerview.adapters.InstrumentAdapter

class listFragment : Fragment() {
    lateinit var v : View
    lateinit var recInstrument: RecyclerView

    var instrumentList : MutableList<Instrument> = mutableListOf()
    lateinit var  adapter: InstrumentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_list, container, false)

        recInstrument = v.findViewById(R.id.recInstrument)
        instrumentList.add(Instrument("0","Guitarra","Gibson","null",
            "https://media.gettyimages.com/photos/blues-guitarist-joe-louis-walker-performs-on-stage-at-the-new-orleans-picture-id90109280?k=20&m=90109280&s=612x612&w=0&h=P_GvCmmD5W39MilILu9uInEdcZFjeyu38ixcX0witkE="))
        instrumentList.add(Instrument("1","Guitarra","Fender","null",
            "https://media.gettyimages.com/photos/ray-davies-of-english-rock-group-the-kinks-performs-playing-a-fender-picture-id84895013?k=20&m=84895013&s=612x612&w=0&h=tGyLHEBLkwHlkjiAiH6T3iVE0VI-euAaWpNCzmXq3mQ="))
        instrumentList.add(Instrument("2","Guitarra","Telecaster","null",
            "https://media.gettyimages.com/photos/american-blues-guitarist-and-singer-buddy-guy-performs-live-on-stage-picture-id84881395?k=20&m=84881395&s=612x612&w=0&h=F4usueRJmHYqEzZdkq9dNZDHKka48mu_dfxfUb5M4Uw="))
        instrumentList.add(Instrument("3","Piano","Cassio","null",
            "https://media.gettyimages.com/photos/american-jazz-pianist-earl-hines-performing-at-a-piano-on-stage-circa-picture-id94258012?k=20&m=94258012&s=612x612&w=0&h=8lZa3iOlFo-bVCWbZKjeZwc4s8z_8c8tQpJurA2jZk0="))

        return v
    }

    override fun onStart() {
        super.onStart()

        adapter = InstrumentAdapter(instrumentList){ position ->
            var action = listFragmentDirections.actionListFragmentToExpandedFragment(instrumentList[position])
            v.findNavController().navigate(action)
        }
        recInstrument.layoutManager = LinearLayoutManager(requireContext())
        recInstrument.adapter = adapter
    }

}