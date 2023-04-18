package com.jimmy.bmiapp

import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class BmiViewModel : ViewModel(){

    private var weight: Int = 0

    private var height: Double = 0.0

    private var result: Double = 0.0

    private var formatRes: Double = 0.0

    fun getBmi(weight: Int,height: Double) :Double{

        val bmiCalOne = BmiCalculator()

        result = bmiCalOne.getBmi(weight,height)

        formatRes = result.roundToInt().toDouble()

        return formatRes

    }



    class BmiCalculator {

        fun getBmi(weight: Int, height: Double): Double {
            var heightSq: Double

            heightSq = height * height

            return weight / heightSq

        }
    }


    fun giveAdvice(results: Double) :String{

        var theAdvice = ""

        val underWeight = "You are underweight"
        val healthyWeight = "You have a healthy weight"
        val overWeight = "You are overweight"
        val obese = "You are obese"

     theAdvice =  if (results < 18.5){
        underWeight
    } else if (results >= 18.5 && results < 25){
             healthyWeight
    } else if (results >= 25 && results <= 29.9){
         overWeight
    } else {
         obese
    }

        return theAdvice
    }


}