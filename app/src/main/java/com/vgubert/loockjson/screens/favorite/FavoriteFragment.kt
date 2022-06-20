package com.vgubert.loockjson.screens.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vgubert.loockjson.R
import com.vgubert.loockjson.databinding.FragmentFavoriteBinding
import com.vgubert.loockjson.databinding.FragmentMainBinding
import com.vgubert.loockjson.screens.main.MainAdapter
import com.vgubert.loockjson.screens.main.MainFragmentViewModel

class FavoriteFragment : Fragment() {

    private var mBinding: FragmentFavoriteBinding?= null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}