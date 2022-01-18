package ru.amaks.ui.painting

import java.awt.*

class ParamFuncPainter(private val plane: Plane) : Painter {
    public var funColor: Color = Color.BLACK
    private val tMin : Double = -10.0
    override fun paint(g : Graphics) {
        with (g as Graphics2D) {
            color = funColor
            stroke = BasicStroke(4F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
            val rh = mapOf(
                RenderingHints.KEY_ANTIALIASING to RenderingHints.VALUE_ANTIALIAS_ON,
                RenderingHints.KEY_INTERPOLATION to RenderingHints.VALUE_INTERPOLATION_BICUBIC,
                RenderingHints.KEY_RENDERING to RenderingHints.VALUE_RENDER_QUALITY,
                RenderingHints.KEY_DITHERING to RenderingHints.VALUE_DITHER_ENABLE,
                RenderingHints.KEY_STROKE_CONTROL to RenderingHints.VALUE_STROKE_PURE,
                RenderingHints.KEY_FRACTIONALMETRICS to RenderingHints.VALUE_FRACTIONALMETRICS_ON,
                RenderingHints.KEY_COLOR_RENDERING to RenderingHints.VALUE_COLOR_RENDER_QUALITY
            )
            setRenderingHints(rh)
            with (plane) {
                var t = tMin
                while (t <= 10.0)
                {
                    drawLine(xCrt2Scr(Xfunc(t)), yCrt2Scr(Yfunc(t)), xCrt2Scr(Xfunc(t+0.1)), yCrt2Scr(Yfunc(t+0.1)))
                    t+=0.1
                }
            }

        }
    }
    private fun Xfunc(t: Double): Double {
            return Math.pow(2.0,t-1)
        }

    private fun Yfunc(t: Double): Double {
             return 0.25 * (Math.pow(t,3.0) + 1)
        }
    }
