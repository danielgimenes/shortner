package com.dgimenes.shortner.createalias

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dgimenes.shortner.Application
import com.dgimenes.shortner.R
import com.dgimenes.shortner.di.CreateAliasModule
import com.dgimenes.shortner.di.CreateAliasViewModelFactory
import kotlinx.android.synthetic.main.activity_create_alias.*
import javax.inject.Inject

class CreateAliasActivity : AppCompatActivity() {

    private lateinit var createAliasViewModel: CreateAliasViewModel

    @Inject
    lateinit var createAliasViewModelFactory: CreateAliasViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_alias)
        Application.componentGraph.newCreateAliasComponent(CreateAliasModule()).inject(this)
        createAliasViewModel = ViewModelProviders.of(this, createAliasViewModelFactory)
                .get(CreateAliasViewModel::class.java)
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