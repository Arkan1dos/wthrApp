package com.example.wthrapp.ui.base

interface BaseContract {
    interface View {
    }

    interface Presenter<V : View> {
        fun onAttach(view: V)
        fun onViewCreated()
        fun onDestroy()
    }
}