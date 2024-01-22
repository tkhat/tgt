package com.example.testactivity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import androidx.activity.viewModels
import com.example.testactivity.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ColorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val colorViewModel: ColorViewModel by viewModels()

    private val cardAdapter by lazy { ColorsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = cardAdapter

        colorViewModel.colorsLiveData.observe(this) {
            cardAdapter.setData(it)
        }
    }
}