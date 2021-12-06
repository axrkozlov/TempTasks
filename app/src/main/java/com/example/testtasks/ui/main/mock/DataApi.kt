package com.example.myapplication.ui.main.mock

import com.example.myapplication.ui.main.mock.ProfileInfo
import java.lang.Exception


class DataApi {
     fun getProfile(id: Long): ProfileInfo {
        return ProfileInfo("Chingiz","19","+77775554433")
    }


     fun getProfiles(): List<ProfileInfo>? {
        return try {
            listOf( ProfileInfo("Chingiz Aitmatov","48","+77775554433"),
                ProfileInfo("David Bowie","23","+77778834426"),
                ProfileInfo("Frank Sinatra","54","+77084133352"),
                ProfileInfo("Amy Winehouse","27","+77776532244"),
            )
        } catch (e:Exception){
            null
        }
    }

     fun insertProfile(profileInfo: ProfileInfo){
        //Stub!
    }

     fun updateProfile(profileInfo: ProfileInfo){
        //Stub!
    }

}