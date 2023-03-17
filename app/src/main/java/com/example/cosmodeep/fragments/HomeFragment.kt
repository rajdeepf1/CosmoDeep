package com.example.cosmodeep.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cosmodeep.adapters.FeedsAdapter
import com.example.cosmodeep.api.ApiService
import com.example.cosmodeep.api.NetworkResult
import com.example.cosmodeep.databinding.FragmentHomeBinding
import com.example.cosmodeep.factories.HomeFactory
import com.example.cosmodeep.repositories.HomeRepository
import com.example.cosmodeep.utils.hide
import com.example.cosmodeep.utils.show
import com.example.cosmodeep.utils.toast
import com.example.cosmodeep.viewmodels.HomeFragmentViewModel
import java.text.SimpleDateFormat
import java.util.*

//2023-02-15
class HomeFragment : Fragment() {

    private val TAG: String? = HomeFragment::class.java.name

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        val homeRepository = HomeRepository(ApiService::class.java)
        val viewModel = ViewModelProvider(this, HomeFactory(homeRepository)).get(
            HomeFragmentViewModel::class.java
        )
        binding.homeFragmentViewModel = viewModel
        binding.lifecycleOwner = this

        val dateFormated = SimpleDateFormat("MMM dd, yyyy").format(Date())

        binding.dateText.text = "Put the date between Jun 16, 1995 and ${dateFormated}"

        viewModel.homeFeeds.observe(viewLifecycleOwner, Observer {
            when (it) {
                is NetworkResult.Loading -> {
                    binding.progressBar.show()
                }

                is NetworkResult.Success -> {
                    binding.progressBar.hide()
                    val obj = it.data!!
                    Log.d(TAG, "onCreateView: ${obj}")

                    // create  layoutManager
                    val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())

                    // pass it to rvLists layoutManager
                    binding.rvList.setLayoutManager(layoutManager)

                    // initialize the adapter,
                    // and pass the required argument
                    val feedsAdapter = FeedsAdapter(obj,requireContext())

                    // attach adapter to the recycler view
                    binding.rvList.adapter = feedsAdapter

                }

                is NetworkResult.Error -> {
                    binding.progressBar.hide()
                    requireContext().toast("Error: ${it.message}")
                }
                else -> {
                    //binding.progressBar.hide()
                }
            }
        })

        return view
    }

}