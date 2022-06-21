package com.vgubert.loockjson.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vgubert.loockjson.R
import com.vgubert.loockjson.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var mBinding: FragmentMainBinding ?= null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        viewModel.getMovies()
        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.setList(list.body()!!.movieItemModels)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}