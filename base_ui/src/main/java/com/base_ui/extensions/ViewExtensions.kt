package com.base_ui.extensions

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.toggleVisibility(showView: Boolean) {
    if (showView) {
        this.visible()
    } else {
        this.gone()
    }
}

fun View.isVisible() = this.visibility == View.VISIBLE
fun View.isGone() = this.visibility == View.GONE
fun View.isInvisible() = this.visibility == View.INVISIBLE


