package com.example.aorjclxvuc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aorjclxvuc.R
import com.example.aorjclxvuc.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo)
    }
}
