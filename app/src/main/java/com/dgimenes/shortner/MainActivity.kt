package com.dgimenes.shortner

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dgimenes.shortner.createalias.CreateAliasActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtons()
    }

    private fun setupButtons() {
        create_alias_button.setOnClickListener {
            openScreen(CreateAliasActivity::class)
        }
        get_link_button.setOnClickListener {
            openScreen(GetLinkActivity::class)
        }
    }

    private fun openScreen(activityKlass: KClass<out Activity>) {
        val intent = Intent(this, activityKlass.java)
        startActivity(intent)
    }
}
