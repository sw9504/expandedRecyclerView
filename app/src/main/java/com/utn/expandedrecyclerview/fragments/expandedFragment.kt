package com.utn.expandedrecyclerview.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.utn.expandedrecyclerview.R

class expandedFragment : Fragment() {
    lateinit var v : View

    lateinit var txtId : TextView
    lateinit var txtName : TextView
    lateinit var txtBrand : TextView
    lateinit var txtDesc : TextView
    lateinit var txtImg : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_expanded, container, false)

        txtId = v.findViewById(R.id.txtId)
        txtName = v.findViewById(R.id.txtNam)
        txtBrand = v.findViewById(R.id.txtBr)
        txtDesc = v.findViewById(R.id.txtDesc)
        txtImg = v.findViewById(R.id.txtUrl)

        return v
    }



    override fun onStart() {
        super.onStart()
        var position = expandedFragmentArgs.fromBundle(requireArguments()).position

        /**
         ** Falta pasarle la lista por argumento
        txtId.text = instrumentList[position].id
        txtName.text = instrumentList[position].name
        txtBrand.text = instrumentList[position].brand
        txtDesc.text = instrumentList[position].desc
        txtImg.text = instrumentList[position].img

         */
    }
}