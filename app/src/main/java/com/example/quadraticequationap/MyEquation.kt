package com.example.quadraticequationap

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.quadraticequationap.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MyEquation(private var binding: ActivityMainBinding) : BaseObservable() {

    @Bindable
    var a : String = ""
        set(value){
            field = value
            notifyPropertyChanged(BR.a)
        }
    @Bindable
    var b : String = ""
        set(value){
            field = value
            notifyPropertyChanged(BR.b)
        }
    @Bindable
    var c : String = ""
        set(value){
            field = value
            notifyPropertyChanged(BR.c)
        }

    fun solveEquation(view: View){
        var a = a.toInt()
        var b = b.toInt()
        var c = c.toInt()

        var x1 : Double
        var x2 : Double

        var discriminant = ((b*b)-(4*a*c))
        if(discriminant>0){
            x1 = (-b+Math.sqrt(discriminant.toDouble()))/(2*a)
            x2 = (-b-Math.sqrt(discriminant.toDouble()))/(2*a)

            binding.resultText.text = "X1 = $x1 , X2 = $x2"
        }else if(discriminant<0){
            binding.resultText.text = "No Real Roots (Complex Roots)"
        }else{
            x1 = (-b/(2*a).toDouble())
            binding.resultText.text = "X1 = $x1"
        }
    }
}