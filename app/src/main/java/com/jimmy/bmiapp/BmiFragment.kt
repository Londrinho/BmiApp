package com.jimmy.bmiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.jimmy.bmiapp.databinding.FragmentBmiBinding
import kotlin.math.roundToInt


class BmiFragment : Fragment() {

    private lateinit var viewModel: BmiViewModel




    private lateinit var binding: FragmentBmiBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(BmiViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bmi, container, false)

        binding.clickBtn.setOnClickListener {
            var weight = 0
            var height = 0.0
            var resultsBmi = 0.0

            weight = binding.weightNum.text.toString().toInt()

            height = binding.heightNum.text.toString().toDouble()

            resultsBmi = viewModel.getBmi(weight,height)

            var advice: String = viewModel.giveAdvice(resultsBmi)

            binding.results.text = resultsBmi.toString()

            binding.advice.text = advice

        }

        binding.clearBtn.setOnClickListener { clear() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.bmiFragment = this


    }
    fun clear () {
        binding.weightNum.text.clear()
        binding.heightNum.text.clear()
        binding.results.text = ""
        binding.advice.text = ""
    }





}

