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

    private var weight: Int = 0

    private var height: Double = 0.0

    private var result: Double = 0.0

    private var formatRes: Double = 0.0


    private lateinit var binding: FragmentBmiBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bmi, container, false)

        binding.clickBtn.setOnClickListener { displayResult() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.bmiFragment = this


    }

    fun displayResult() {

        val bmiCalOne = BmiCalculator()

        weight = binding.weightNum.text.toString().toInt()

        height = binding.heightNum.text.toString().toDouble()

        result = bmiCalOne.getBmi(weight,height)

        formatRes = result.roundToInt().toDouble()

        binding.results.text = formatRes.toString()

    }

    class BmiCalculator {

        fun getBmi(weight: Int, height: Double): Double {
            var heightSq: Double

            heightSq = height * height

            return weight / heightSq

        }


    }
}

//println("%.2f".format(result))
//TODO - put in formating for 2 decimal places and enact clear button