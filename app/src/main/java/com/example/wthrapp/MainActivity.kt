package com.example.wthrapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wthrapp.ui.main.MainFragment
import com.example.wthrapp.utils.addFragment
import com.example.wthrapp.utils.popBackStack

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(MainFragment(), supportFragmentManager)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        popBackStack(supportFragmentManager)
    }
}