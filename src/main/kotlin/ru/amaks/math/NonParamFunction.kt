package ru.amaks.math

interface NonParamFunction {
    fun eval(x: Double) : Double
    fun isInDomain(x : Double) : Boolean
}