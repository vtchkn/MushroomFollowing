package com.vtchkn.mushroomfollowing

import android.app.Application
import android.os.Build
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.actionCodeSettings
import com.vtchkn.mushroomfollowing.api.model.MushroomGrowingEntity
import com.vtchkn.mushroomfollowing.repository.MushroomFollowingRepository
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel(
    private val mushroomFollowingRepository: MushroomFollowingRepository? = null
) : ViewModel() {
    private val additivesLiveData: MutableLiveData<Result<List<AdditiveVD?>>> = MutableLiveData()
    fun getAdditivesLiveData(): LiveData<Result<List<AdditiveVD?>>> {
        return additivesLiveData
    }

    fun fetch() {
        viewModelScope.launch {
//            if (isSignedIn()){

//                    getMushroomGrowingEntities()
//                    getMeasurements()
//                    getSubstrates()
//                    getStages()
            mushroomFollowingRepository?.getAdditives()?.collect {
                additivesLiveData.postValue(it)
            }
        }
    }


    fun save(it: MushroomGrowingEntity) {
        viewModelScope.launch {

        }
    }

    private fun isSignedIn(): Boolean {
        return FirebaseAuth.getInstance().currentUser != null
    }
}