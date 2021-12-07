package com.example.testtasks.ui.main.task2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testtasks.ui.main.mock.DataApi
import com.example.testtasks.ui.main.mock.ProfileInfo
import com.example.testtasks.R
import kotlinx.android.synthetic.main.main_fragment.*

class Task2Fragment : Fragment() {

    // #TrashCode
    // This code displays cached user profiles on screen while loading actual data,
    // after loading it shows actual data on screen and update cashed data.
    // What's wrong with the code?
    // 1. Please, make the code better.
    // 2. Please, implement update function.

    var profiles:List<ProfileInfo>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progressBar.visibility = View.VISIBLE
        //Show cached profiles on display while loading
        for (i in 1..10) {
            val preferences = activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
            nameEditText.setText(preferences?.getString("name", ""))
            ageEditText.setText(preferences?.getString("age", ""))
            phoneNumberEditText.setText(preferences?.getString("phoneNumber", ""))
        }
        val api = DataApi()
        object : Thread() {
            override fun run() {
                super.run()
                profiles = api.getProfiles()
                saveProfilesCache()
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun saveProfilesCache() {
        //Save a profiles to cache
        var names = ""
        var ages = ""
        var numbers = ""
        for (i in 1..profiles!!.size) {
            val preferences = activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
            names = names + profiles!![i].name + ","
            preferences?.edit()?.putString("name",names)!!.apply()
            ages = names + profiles!![i].age + ","
            preferences.edit()?.putString("age",ages)!!.apply()
            numbers = names + profiles!![i].phoneNumber + ","
            preferences.edit()?.putString("number",numbers)!!.apply()
            //Update all profiles on display
            nameEditText.setText(names)
            ageEditText.setText(ages)
            phoneNumberEditText.setText(numbers)
        }
    }

    private fun updateProfile(){
        //TODO:Implement
    }

}