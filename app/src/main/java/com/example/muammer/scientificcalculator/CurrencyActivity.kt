package com.example.muammer.scientificcalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class CurrencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menuScientific->{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.menuUnit->{
                val intent = Intent(this,UnitActivity::class.java)
                startActivity(intent)
            }



        }
        return super.onOptionsItemSelected(item)
    }
}
