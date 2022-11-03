package com.IceStorm.DragBattl.wh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.IceStorm.DragBattl.R
import com.IceStorm.DragBattl.databinding.ActivityStartBinding

class Start : AppCompatActivity() {
    private lateinit var bindStrt: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindStrt = ActivityStartBinding.inflate(layoutInflater)
        setContentView(bindStrt.root)

        bindStrt.startBtn.setOnClickListener{
            startActivity(Intent(this, Gamm::class.java))
        }
    }
}