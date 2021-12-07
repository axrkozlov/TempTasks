package com.example.testtasks.ui.main.task3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.ui.main.task3.Task3ViewModel
import com.example.testtasks.R

class Task3Fragment : Fragment() {

    // This code displays user profiles on screen
    // 1. Get UserProfiles from mock local data source
    // 2. Implement extension function to map list of user profiles to list of user names + user phones
    // 3. Bind data list to one TextView with bold username text, grey colored phone number

    private lateinit var viewModel: Task3ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Task3ViewModel::class.java)
    }

}