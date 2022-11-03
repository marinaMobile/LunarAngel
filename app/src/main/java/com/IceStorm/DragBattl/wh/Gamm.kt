package com.IceStorm.DragBattl.wh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import com.IceStorm.DragBattl.R
import com.IceStorm.DragBattl.databinding.ActivityGammBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Gamm : AppCompatActivity() {
    val roll = mutableListOf<String>("1", "2", "3")
    private lateinit var bindGamm: ActivityGammBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindGamm = ActivityGammBinding.inflate(layoutInflater)
        setContentView(bindGamm.root)

        var one: String = ""
        var two: String = ""
        var three: String = ""

        var first: ImageView = bindGamm.first
        var second: ImageView = bindGamm.second
        var third: ImageView = bindGamm.third

        val s: Long = "5".toLong() * 1000

        object : CountDownTimer(s, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                bindGamm.running.text = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                MaterialAlertDialogBuilder(this@Gamm)
                    .setTitle("Time's Up")
                    .setCancelable(false)
                    .setPositiveButton("Play again") { dialog, _ ->

                        startActivity(Intent(applicationContext, Gamm::class.java))
                        finish()
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }.start()



        bindGamm.button2.setOnClickListener {
            three = roll.random()
            check(one, first)
            check(three, third)
            check(two, second)
            checkWin(one, two, three)
        }

        bindGamm.button1.setOnClickListener {
            one = roll.random()
            check(one, first)
            check(three, third)
            check(two, second)
            checkWin(one, two, three)
        }
        bindGamm.button3.setOnClickListener {
            two = roll.random()
            check(one, first)
            check(three, third)
            check(two, second)
            checkWin(one, two, three)
        }

    }

    fun check(i: String, im: ImageView) {
        if (i == "1") {
            im.setImageResource(R.drawable.one)
        } else if (i == "2") {
            im.setImageResource(R.drawable.two)
        } else if (i == "3") {
            im.setImageResource(R.drawable.three)
        }
    }

    fun checkWin(i: String, i1: String, i2: String) {
        if (i == "1" && i1 == "1" && i2 == "1") {
            intentr()
        } else if (i == "2" && i1 == "2" && i2 == "2") {
            intentr()

        } else if (i == "3" && i1 == "3" && i2 == "3") {
            intentr()
        }
    }


    fun intentr() {
        val intent = Intent(this, Gamm::class.java)
        startActivity(intent)
    }
}