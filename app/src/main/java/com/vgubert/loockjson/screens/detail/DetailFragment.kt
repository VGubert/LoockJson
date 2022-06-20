package com.vgubert.loockjson.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vgubert.loockjson.R
import com.vgubert.loockjson.databinding.FragmentDetailBinding
import com.vgubert.loockjson.databinding.FragmentMainBinding
import com.vgubert.loockjson.screens.favorite.FavoriteFragmentViewModel
import com.vgubert.loockjson.screens.main.MainAdapter

class DetailFragment : Fragment() {

    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}