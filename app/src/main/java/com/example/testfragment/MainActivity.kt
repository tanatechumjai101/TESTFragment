package com.example.testfragment

import android.content.Intent
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnBack.apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity, BackStackActivity::class.java)
                startActivity(intent)
            }
        }
        Btn1.apply {
            setOnClickListener {
                addFragment(OneFragment(),false, "One")
            }
        }
        Btn2.apply {
            setOnClickListener {
                addFragment(TwoFragment(),false,"Two")
            }
        }
    }
    fun addFragment(fragment: Fragment,addTobackStack: Boolean, tag: String){
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        if(addTobackStack){
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.container_frame,fragment,tag)
        ft.commitAllowingStateLoss()
    }
}
