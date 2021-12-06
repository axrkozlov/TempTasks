package com.example.testtasks.ui.main.mock

import com.example.myapplication.ui.main.mock.ProfileInfo

class LocalDataSource {
    fun getProfile(id: Long): ProfileInfo {
        return ProfileInfo("Chingiz","19","+77775554433")
    }


    fun getProfiles(): List<ProfileInfo> {
        return listOf( ProfileInfo("Chingiz Aitmatov","48","+77775554433"),
            ProfileInfo("David Bowie","23","+77778834426"),
            ProfileInfo("Frank Sinatra","54","+77084133352"),
            ProfileInfo("Amy Winehouse","27","+77776532244"),
        )
    }

    fun insertProfile(profileInfo: ProfileInfo){
        //Stub!
    }

    fun updateProfile(profileInfo: ProfileInfo){
        //Stub!
    }



}
