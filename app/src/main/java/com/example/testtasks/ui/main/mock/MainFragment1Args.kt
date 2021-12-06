package com.example.myapplication.ui.main.mock

import com.example.testtasks.ui.main.task4.Task4Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class MainFragment1Args(val currentId: Long)
fun navArgs(): ReadOnlyProperty<Task4Fragment, MainFragment1Args> =
    object : ReadOnlyProperty<Task4Fragment?, MainFragment1Args> {
        var curValue = MainFragment1Args(5)
        override fun getValue(thisRef: Task4Fragment?, property: KProperty<*>): MainFragment1Args = curValue
    }
