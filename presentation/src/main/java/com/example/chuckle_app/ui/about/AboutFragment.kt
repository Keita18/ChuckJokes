package com.example.chuckle_app.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chuckle_app.ChuckleApplication
import com.example.chuckle_app.R
import kotlinx.android.synthetic.main.fragment_about.view.*


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val glide = (requireActivity().application as ChuckleApplication).applicationComponent.getGlide()

        val url = "https://picsum.photos/1000/600"
        glide
            .load(url)
            .override(1000, 600)
            .centerCrop()
            .into(view.image)

        return view
    }

}