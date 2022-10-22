package com.example.happyplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddHappyPlaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_happy_place)

        var toolbarAddPlace : Toolbar = findViewById(R.id.toolbar_add_place)
        setSupportActionBar(toolbarAddPlace)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarAddPlace.setNavigationOnClickListener{
            onBackPressed()
        }
    }
}