package com.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.base_ui.extensions.openFragment
import com.template.ui.country.createListCountriesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.main_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            openFragment(R.id.container, createListCountriesFragment())
        }
    }
}