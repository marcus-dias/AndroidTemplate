package com.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.base_ui.extensions.openFragment
import com.template.ui.main.createMainFragment

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            openFragment(R.id.container, createMainFragment())
        }
    }
}