package com.utn.expandedrecyclerview.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.utn.expandedrecyclerview.R

class fullImgFragment : Fragment() {
    lateinit var v : View
    lateinit var imgFull : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_full_img, container, false)
        imgFull = v.findViewById(R.id.imgFull)
        return v
    }

    override fun onStart() {
        super.onStart()

        var url = fullImgFragmentArgs.fromBundle(requireArguments()).urlArg

        Glide.with(requireContext())
            .load(url)
            .into(imgFull)
    }
}