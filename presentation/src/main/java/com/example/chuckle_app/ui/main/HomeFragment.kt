package com.example.chuckle_app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.chuckle_app.R
import com.example.chuckle_app.ui.main.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager = pager
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tab_layout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Jokes"
                    tab.icon = resources.getDrawable(R.drawable.ic_haha)
                }
                else -> {
                    tab.text = "Web"
                    tab.icon = resources.getDrawable(R.drawable.ic_web)
                }
            }

        }.attach()
    }

}