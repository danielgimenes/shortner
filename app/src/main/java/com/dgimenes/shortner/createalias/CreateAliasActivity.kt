package com.dgimenes.shortner.createalias

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dgimenes.shortner.R
import kotlinx.android.synthetic.main.activity_create_alias.*

class CreateAliasActivity : AppCompatActivity() {

    private lateinit var createAliasViewModel: CreateAliasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_alias)
        createAliasViewModel = ViewModelProviders.of(this).get(CreateAliasViewModel::class.java)
        setupUI()
    }

    private fun setupUI() {
        create_alias_button.setOnClickListener {
            createAliasViewModel.createAliasForLink(original_link_edit_text.text.toString())
                    .observe(this,
                            Observer { alias ->
                                alias_text_view.text = alias
                            }
                    )
        }
    }
}