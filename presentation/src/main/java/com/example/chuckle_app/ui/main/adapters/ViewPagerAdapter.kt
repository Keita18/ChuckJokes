package com.example.chuckle_app.ui.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chuckle_app.ui.main.ListFragment
import com.example.chuckle_app.ui.main.WebViewFragment

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
//        val fragment = DemoObjectFragment()
//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, position + 1)
//        }
        return when(position) {
            0 -> ListFragment()
            else -> WebViewFragment()
        }
    }

}