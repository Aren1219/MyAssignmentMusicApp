package com.example.myassignmentca.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmentca.R
import com.example.myassignmentca.adapters.MusicAdapter
import com.example.myassignmentca.databinding.FragmentClassicBinding
import com.example.myassignmentca.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClassicFragment : Fragment(R.layout.fragment_classic) {
    private lateinit var binding: FragmentClassicBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel by lazy {
            ViewModelProvider(requireActivity())[ClassicViewModel::class.java]
        }
        binding = FragmentClassicBinding.bind(view)

        binding.rvMusic.apply {
//            setBackgroundResource(R.color.bgClassicMusic)
            background = AppCompatResources.getDrawable(context, R.color.yellow)
            layoutManager = LinearLayoutManager(context)
        }

        binding.srMusic.setOnRefreshListener {
            viewModel.getClassicMusic()
        }

        viewModel.getClassicMusic()

        viewModel.musicDetails.observe(requireActivity()) { state ->
            when(state) {
                is UiState.Loading -> {
                    Log.i("API Response: ", "LOADING")
                    binding.srMusic.isRefreshing = true
                }
                is UiState.Success -> {
                    Log.i("API Response: ", "SUCCESS -> ${state.musicResponse}")
                    binding.rvMusic.adapter = MusicAdapter(requireContext(),state.musicResponse.results)
                    binding.srMusic.isRefreshing = false
                }
                is UiState.Error -> {
                    Log.i("API Response: ", "Error -> ${state.error}")
                    binding.srMusic.isRefreshing = false
                }
            }
        }
    }
}