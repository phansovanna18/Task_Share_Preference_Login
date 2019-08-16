package com.example.tasksharepre_login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import android.content.Intent



class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        objPre = class_SharePrefernce(applicationContext)
        txtUser.text = objPre.getUser()
        txtPassword.text = objPre.getPassword()
    }

    private lateinit var objPre:class_SharePrefernce

    override fun onBackPressed() {
        super.onBackPressed()
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btnLogOut -> {
                objPre.putUser("")
                objPre.putPassword("")
                objPre.putLogin(false)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
