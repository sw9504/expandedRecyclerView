package com.utn.expandedrecyclerview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.utn.expandedrecyclerview.R

class expandedFragment : Fragment() {
    lateinit var v : View

    lateinit var txtId : TextView
    lateinit var txtName : TextView
    lateinit var txtBrand : TextView
    lateinit var txtDesc : TextView
    lateinit var txtImg : TextView
    lateinit var imgAvatar: ImageView

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
        imgAvatar = v.findViewById(R.id.imgAvatar)

        return v
    }

    override fun onStart() {
        super.onStart()
        var instrumentList = expandedFragmentArgs.fromBundle(requireArguments()).instrumentObj

        txtId.text = instrumentList.id
        txtName.text = instrumentList.name
        txtBrand.text = instrumentList.brand
        txtDesc.text = instrumentList.desc
        txtImg.text = instrumentList.url

        Glide.with(requireContext())
            .load(instrumentList.url)
            .into(imgAvatar)

        imgAvatar.setOnClickListener {
            var action = expandedFragmentDirections.actionExpandedFragmentToFullImgFragment(instrumentList.url)
            v.findNavController().navigate(action)
        }

    }
}