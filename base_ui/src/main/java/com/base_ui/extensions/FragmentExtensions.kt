package com.base_ui.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

fun Fragment.baseFragmentInitialization(
    inflater: LayoutInflater,
    container: ViewGroup?,
    @LayoutRes rootLayoutRes: Int,
    @LayoutRes layoutResId: Int
): ViewGroup {
    val baseView =
        inflater.inflate(
            rootLayoutRes,
            container,
            false
        ) as ViewGroup
    val content = inflater.inflate(
        layoutResId,
        baseView,
        false
    )
    baseView.addView(content, 0)
    return baseView
}