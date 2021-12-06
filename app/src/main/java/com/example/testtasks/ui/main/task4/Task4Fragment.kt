package com.example.testtasks.ui.main.task4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.main.mock.*
import com.example.myapplication.ui.main.mock.DataApi
import com.example.myapplication.ui.main.task4.Task4ViewModel
import com.example.testtasks.R
import com.example.testtasks.ui.main.mock.LocalDataSource
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Task4Fragment : Fragment(){

    //Improve the code
    //The Fragment shows user profile data, allows update user profile data on server, cache new data to local database

    companion object {
        fun newInstance() = Task4Fragment()
    }

    private lateinit var viewModel: Task4ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    private val args: MainFragment1Args by navArgs()

    var currentId: Long? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Task4ViewModel::class.java)
        currentId = args.currentId
        updateButton.setOnClickListener {
            GlobalScope.launch {
                updateMyProfile()
            }
        }
    }

    val api = DataApi()
    val db = LocalDataSource()
    suspend fun updateMyProfile() {
        GlobalScope.launch {
            nameEditText.setText(db.getProfile(id = currentId!!).name)
            phoneNumberEditText.setText(db.getProfile(id = currentId!!).phoneNumber)
            ageEditText.setText(db.getProfile(id = currentId!!).age)
            api.updateProfile(
                ProfileInfo(
                    nameEditText.text.toString(),
                    ageEditText.text.toString(),
                    phoneNumberEditText.text.toString()
                ))
        }
    }


}
