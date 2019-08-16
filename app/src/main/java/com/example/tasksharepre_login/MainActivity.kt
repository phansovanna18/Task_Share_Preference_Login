package com.example.tasksharepre_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        objPre= class_SharePrefernce(applicationContext)
    }

    fun click(view: View){
        when(view.id){
            R.id.btnLogin -> {
                if(editText_User.text.toString() == "" && editText_Password.text.toString() == "")
                    Snackbar.make(view,"The User is empty",Snackbar.LENGTH_SHORT).show()
                else{
                    objPre.putUser(editText_User.text.toString())
                    objPre.putPassword(editText_Password.text.toString())
                    objPre.putLogin(true)
                    startLogin()
                }
            }
            R.id.btnForget -> {
                Snackbar.make(view,"It does not have Function",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        startLogin()
    }

    private lateinit var objPre:class_SharePrefernce

    private fun startLogin(){
        if (objPre.getLogin()!!){
            var i = Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(i)
        }
    }
}
