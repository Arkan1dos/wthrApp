package com.example.wthrapp.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.wthrapp.R

fun Activity.addFragment(fragment: Fragment?, fragmentManager: FragmentManager) {
    if (fragment == null) return
    val tr = fragmentManager.beginTransaction()
    tr.replace(R.id.fragment_container_view, fragment, fragment.javaClass.name)
        .addToBackStack(null)
    tr.commitAllowingStateLoss()
}

fun Fragment.addFragment(fragment: Fragment, fragmentManager: FragmentManager) {
    val ft = fragmentManager.beginTransaction()
    ft.replace(R.id.fragment_container_view, fragment, fragment.javaClass.name)
        .addToBackStack(null)
    ft.commitAllowingStateLoss()
}

fun Fragment.popBackStack() {
    val fm = this.parentFragmentManager
    println("+++++++1 " + fm.fragments.size)
    println("+++++++2 " + fm.backStackEntryCount)
    if (fm.backStackEntryCount > 1) {
        fm.popBackStack()
    }
}

fun Activity.popBackStack(fragmentManager: FragmentManager) {
    println("+++++++1 " + fragmentManager.fragments.size)
    println("+++++++2 " + fragmentManager.backStackEntryCount)
    if (fragmentManager.backStackEntryCount > 1) {
        fragmentManager.popBackStack()
    }
}