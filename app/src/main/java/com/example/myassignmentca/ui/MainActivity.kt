package com.example.myassignmentca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.myassignmentca.R
import com.example.myassignmentca.adapters.ViewPagerAdapter
import com.example.myassignmentca.databinding.ActivityMainBinding
import com.example.myassignmentca.util.UiState
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(R.layout.item_music)
        setContentView(binding.root)

        val myViewPager: ViewPager2 = findViewById(R.id.viewPager)
        val myTabLayout: TabLayout = findViewById(R.id.tabLayout)

        val texts = listOf("Classic", "Rock", "Pop")
        val mAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        myViewPager.adapter = mAdapter

        TabLayoutMediator(myTabLayout,myViewPager){tab,position->

            tab.text=texts[position]

        }.attach()
    }
}