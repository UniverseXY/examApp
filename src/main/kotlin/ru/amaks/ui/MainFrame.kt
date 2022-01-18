package ru.amaks.ui

import ru.amaks.ui.painting.*
import ru.amaks.ui.painting.Painter
import java.awt.*
import java.awt.event.*
import java.util.prefs.PreferenceChangeEvent
import javax.swing.*


class MainFrame: JFrame() {

    val minDim = Dimension(1200, 600)
   /* var xMin: JSpinner
    var yMin : JSpinner
    var xMax: JSpinner
    var yMax : JSpinner
    val xMinLbl : JLabel
    val xMaxLbl : JLabel
    val yMinLbl : JLabel
    val yMaxLbl : JLabel
    val xMaxM : SpinnerNumberModel
    val xMinM : SpinnerNumberModel
    val yMaxM : SpinnerNumberModel
    val yMinM : SpinnerNumberModel*/
    val panel: GraphicsPanel
    val infoPanel : JPanel
    val label1 : JLabel
    val label2 : JLabel
    val bluePanel : JPanel
    val blackPanel : JPanel
    var painters : MutableList<Painter> = mutableListOf<Painter>()
    init {
        defaultCloseOperation = EXIT_ON_CLOSE // Чтобы приложение завершало работу при закрытии
        minimumSize = minDim // Устанавливаем минимальный размер формы

        /*xMinM = SpinnerNumberModel(-5.0, -100.0, 4.9, 0.1)
        yMinM = SpinnerNumberModel(-5.0, -100.0, 4.9, 0.1)
        xMaxM = SpinnerNumberModel(5.0, -4.9, 100.0, 0.1)
        yMaxM = SpinnerNumberModel(5.0, -4.9, 100.0, 0.1)
        xMin = JSpinner(xMinM)
        yMin = JSpinner(yMinM)
        xMax = JSpinner(xMaxM)
        yMax = JSpinner(yMaxM)*/
       // val mainPlane = Plane(xMinM.value as Double  , xMaxM.value as Double, yMinM.value as Double, yMaxM.value as Double)
        val mainPlane = Plane(-15.0  , 15.0, -15.0, 15.0)
        val cartesianPainter = CartesianPainter(mainPlane)
        val nonParamPainter = NonParamPainter(mainPlane, fun (x :Double) = Math.sqrt(16 - x*x))
        val paramPainter = ParamFuncPainter(mainPlane)
        painters.add(cartesianPainter)
        painters.add(nonParamPainter)
        painters.add(paramPainter)
        title = "Построение графика функции"
        panel = GraphicsPanel(painters).apply {
            background = Color.WHITE
        }
        infoPanel = JPanel().apply {
            background = Color.PINK
        }
        label1 = JLabel().apply {
            text = "y = √16 - x² "
            font = getFont().deriveFont(16.0f)
        }
        label2 = JLabel().apply {
            text = "Параметрическая функция"
            font = getFont().deriveFont(16.0f)
        }
       /* xMinLbl = JLabel().apply {
            text = "Xmin"
        }
        xMaxLbl = JLabel().apply {
            text = "Xmax"
        }
        yMinLbl = JLabel().apply {
            text = "Ymin"
        }
        yMaxLbl = JLabel().apply {
            text = "Ymax"
        }*/
        bluePanel = JPanel().apply {
            background = Color.BLUE
        }
        blackPanel = JPanel().apply {
            background = Color.BLACK
        }
        mainPlane.pixelSize = panel.size
        // Обработчик события изменения размеров панели
        panel.addComponentListener(object: ComponentAdapter(){
            override fun componentResized(e : ComponentEvent?){
                mainPlane.pixelSize = panel.size
                panel.repaint() // Вызов метода paint с buffered graphics
            }
        })

        layout = GroupLayout(contentPane).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                            .addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                    )
                    .addGap(4)
            )
            setVerticalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                    .addComponent(infoPanel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                    .addGap(4)
            )

        }
        infoPanel.layout = GroupLayout(infoPanel).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    /*.addGap(100)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(xMinLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yMinLbl,  GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(10)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(xMin, 100, GroupLayout.PREFERRED_SIZE, Int.MAX_VALUE)
                            .addComponent(yMin,  100, GroupLayout.PREFERRED_SIZE, Int.MAX_VALUE)
                    )
                    .addGap(20)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(xMaxLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yMaxLbl,  GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(10)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(xMax, 100, GroupLayout.PREFERRED_SIZE, Int.MAX_VALUE)
                            .addComponent(yMax,  100, GroupLayout.PREFERRED_SIZE, Int.MAX_VALUE)
                    )
                    .addGap(50)*/
                    .addGap(500)
                    .addGroup(
                        createParallelGroup()
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(bluePanel, 20, 20, 20)
                                    .addGap(10)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(4,4, Int.MAX_VALUE)
                            )
                            .addGap(50)
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(blackPanel, 20, 20, 20)
                                    .addGap(10)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(4,4,Int.MAX_VALUE)
                            )

                    )
                    .addGap(500)
            )
            setVerticalGroup(
                createSequentialGroup()
                    .addGap(50)
                    .addGroup(
                        createParallelGroup()
                            /*.addComponent(xMinLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(xMin, 20, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(xMaxLbl,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(xMax, 20, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)*/
                            .addComponent(bluePanel, 20,20,20)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(50)
                    .addGroup(
                        createParallelGroup()
                           /* .addComponent(yMinLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yMin, 20, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yMaxLbl,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yMax, 20, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)*/
                            .addComponent(blackPanel, 20,20,20)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(50)
            )
        }

       /* xMin.addChangeListener{
            xMaxM.minimum = xMin.value as Double + 0.1
            mainPlane.xSegment = Pair(xMin.value as Double, xMax.value as Double)
            panel.repaint()
        }
        xMax.addChangeListener{
            xMinM.maximum = xMax.value as Double - 0.1
            mainPlane.xSegment = Pair(xMin.value as Double, xMax.value as Double)
            panel.repaint()
        }
        yMin.addChangeListener{
            yMaxM.minimum = yMin.value as Double + 0.1
            mainPlane.ySegment = Pair(yMin.value as Double, yMax.value as Double)
            panel.repaint()
        }
        yMax.addChangeListener{
            yMinM.maximum = yMax.value as Double - 0.1
            mainPlane.ySegment = Pair(yMin.value as Double, yMax.value as Double)
            panel.repaint()
        }*/
        pack() // Пересчет размеров компонентов
        mainPlane.width = panel.width
        mainPlane.height = panel.height
    }
}

