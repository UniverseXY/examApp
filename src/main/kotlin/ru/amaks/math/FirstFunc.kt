package ru.amaks.math

import java.lang.Math.abs

class FirstFunc() : NonParamFunction {
    override fun isInDomain(x: Double): Boolean {
        return if (abs(x) le 4.0) true else false
    }

    override fun eval(x: Double): Double {
        return Math.sqrt(16.0 - x*x)
    }
}