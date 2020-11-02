package mx.tecnm.ladm_u2_ejercicio2_drivera

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View

class Lienzo (p:MainActivity) : View(p){

    var xC = 270f
    var yC = 270f
    var incC = 5

    var xRi = 300f
    var yRi = 300f
    var xRf = xRi*2
    var yRf = yRi*2
    var incRy = 5


    var trabajando = false

    val timer = object : CountDownTimer(2000,100){
        override fun onTick(millisUntilFinished: Long) {
            //circulo
            xC = xC + incC
            if(xC <=-50 || xC >= 700){
                incC = incC*-1
            }


            //rectangulo
            yRi = yRi+incRy
            yRf = yRf+incRy
            if (yRf<=-50 || yRf >= 1500){
                incRy = incRy*-1
            }
            invalidate()
        }

        override fun onFinish() {
            start()
        }
    }//timer

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p = Paint()

        c.drawColor(Color.DKGRAY)

        //circulo
        p.strokeWidth = 7f
        p.setColor(Color.YELLOW)
        c.drawCircle(xC,yC,100f,p)
        p.style = Paint.Style.STROKE
        p.setColor(Color.BLACK)
        c.drawCircle(xC,yC,100f,p)


        //rectangulo
        p.style = Paint.Style.FILL
        p.setColor(Color.CYAN)
        c.drawRect(xRi,yRi,xRf,yRf,p)
        p.style = Paint.Style.STROKE
        p.setColor(Color.BLUE)
        c.drawRect(xRi,yRi,xRf,yRf,p)

    }//onDraw


    override fun onTouchEvent(event: MotionEvent): Boolean {

        if(event.action == MotionEvent.ACTION_DOWN){
            if (trabajando == false){
                timer.start()
                trabajando = true
            }
        }

        return true
    }//onTouchEvent

}//Lienzo