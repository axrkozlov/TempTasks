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

    //What's wrong with the code?
    //Please, make the code better.
    //Implement update function

    companion object {
        fun newInstance() = Task2Fragment()
    }

    var profiles:List<ProfileInfo>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progressBar.visibility = View.VISIBLE
        //Get data from cache while loading
        val preferences = activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        nameEditText.setText(preferences?.getString("name",""))
        ageEditText.setText(preferences?.getString("age",""))
        phoneNumberEditText.setText(preferences?.getString("phoneNumber",""))
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
        for (i in 1..profiles!!.size) {
            val preferences = activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
            preferences?.edit()?.putString("name",profiles!![i].name)!!.apply()
            preferences.edit()?.putString("age",profiles!![i].age)!!.apply()
            preferences.edit()?.putString("number",profiles!![i].phoneNumber)!!.apply()
            nameEditText.setText(profiles!![i].name)
            ageEditText.setText(profiles!![i].age)
            phoneNumberEditText.setText(profiles!![i].phoneNumber)
        }
    }

    private fun updateProfile(){

    }

}