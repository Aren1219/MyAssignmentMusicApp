package com.example.myassignmentca.adapters

import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myassignmentca.ui.ClassicFragment
import com.example.myassignmentca.ui.PopFragment
import com.example.myassignmentca.ui.RockFragment

private const val NUM_TABS = 3

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int) = when (position) {
        0 -> ClassicFragment()
        1 -> RockFragment()
        else -> PopFragment()
    }

}