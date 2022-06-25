package com.vgubert.loockjson.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vgubert.loockjson.MAIN
import com.vgubert.loockjson.R
import com.vgubert.loockjson.SaveShared
import com.vgubert.loockjson.databinding.FragmentDetailBinding
import com.vgubert.loockjson.databinding.FragmentMainBinding
import com.vgubert.loockjson.models.MovieItemModel
import com.vgubert.loockjson.screens.favorite.FavoriteFragmentViewModel
import com.vgubert.loockjson.screens.main.MainAdapter

class DetailFragment : Fragment() {

    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding!!
    lateinit var currentMovie: MovieItemModel
    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("movie") as MovieItemModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBool = SaveShared.getFavorite(MAIN, currentMovie.id.toString())
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        if(isFavorite != valueBool) {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_favorite_fill)
        } else {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_favorite)
        }
        Glide.with(MAIN)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${currentMovie.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetail)
        binding.tvTitle.text = currentMovie.title
        binding.tvDate.text = currentMovie.release_date
        binding.tvDescription.text = currentMovie.overview

        binding.imgDetailFavorite.setOnClickListener {
            if(isFavorite == valueBool) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_favorite_fill)
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), true)
                viewModel.insert(currentMovie) {}
                isFavorite = true
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_favorite)
                viewModel.delete(currentMovie) {}
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), false)
                isFavorite = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}