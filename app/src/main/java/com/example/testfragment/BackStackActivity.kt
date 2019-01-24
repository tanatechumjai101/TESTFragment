package com.example.testfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button

class BackStackActivity : AppCompatActivity() {

    lateinit var btnFrag1WithBack: Button
    lateinit var btnFrag2WithBack: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)
        btnFrag1WithBack = findViewById(R.id.Btn1with) as Button
        btnFrag2WithBack = findViewById(R.id.Btn2with) as Button

        btnFrag1WithBack!!.setOnClickListener {
            addFragment(OneFragment(), true,"one1")
        }
        btnFrag2WithBack!!.setOnClickListener {
            addFragment(TwoFragment(),true,"two2")
        }

    }
    fun addFragment (fragment: Fragment, addToBackStack: Boolean,tag: String){
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        if (addToBackStack){
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.container_frame_back,fragment,tag)
        ft.commitAllowingStateLoss()
    }
}
