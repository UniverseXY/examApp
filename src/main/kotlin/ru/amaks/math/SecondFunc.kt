package ru.amaks.math

class SecondFunc() : ParamFunction {
    override val step: Double
        get() = 0.1
    override val tMax: Double
        get() = 10.0
    override val tMin: Double
        get() = -10.0
    override fun Xfunc(t: Double): Double {
        return Math.pow(2.0,t-1)
    }

    override fun Yfunc(t: Double): Double {
        return 0.25 * (Math.pow(t,3.0) + 1)
    }
}
