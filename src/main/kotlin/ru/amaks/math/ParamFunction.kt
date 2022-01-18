package ru.amaks.math

interface ParamFunction {
    val tMin : Double
    val tMax : Double
    val step : Double
    fun Xfunc (t : Double) : Double
    fun Yfunc (t : Double) : Double
}