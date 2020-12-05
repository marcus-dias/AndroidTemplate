package com.base_ui.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.openFragment(
    @IdRes container: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false
) {
    if (addToBackStack) {
        addFragment(container, fragment)
    } else {
        replaceFragment(container, fragment)
    }
}

private fun AppCompatActivity.replaceFragment(@IdRes container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(container, fragment)
        .commitNow()
}

private fun AppCompatActivity.addFragment(@IdRes container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .add(container, fragment)
        .commitNow()
}