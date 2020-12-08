package com.base_ui.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.openFragment(
    @IdRes container: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false
) {
    when (addToBackStack) {
        true -> addFragment(container, fragment)
        false -> replaceFragment(container, fragment)
    }
}

private fun FragmentActivity.replaceFragment(@IdRes container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(container, fragment)
        .commitNow()
}

private fun FragmentActivity.addFragment(@IdRes container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .add(container, fragment)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}