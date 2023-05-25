package com.example.tempertureconvertapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tempertureconvertapp.databinding.FragmentTemperatureBinding


class TemperatureFragment : Fragment() {

    private val viewModel: TemperatureViewModel by viewModels()

    private lateinit var binding: FragmentTemperatureBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_temperature, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.temperatureViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        binding.celsiusBtn.setOnClickListener { getCelsiusTemp() }

        binding.clearBtn.setOnClickListener { clearCelsiusField() }
    }

    fun getCelsiusTemp(){
        val fanTemp = binding.textInputEditText.text.toString().toInt()

        viewModel.fanToCel(fanTemp)

        binding.celsiusText.text = fanTemp.toString()

        binding.textInputEditText.text = null


    }

    private fun clearCelsiusField(){
        viewModel.reinitialiseData()
        binding.celsiusText.text = null
    }


}