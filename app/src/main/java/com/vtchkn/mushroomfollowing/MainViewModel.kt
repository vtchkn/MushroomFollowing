package com.vtchkn.mushroomfollowing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.vtchkn.mushroomfollowing.api.model.MushroomGrowingEntity
import com.vtchkn.mushroomfollowing.repository.*
import com.vtchkn.mushroomfollowing.viewdata.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
class MainViewModel(
    private val mushroomFollowingRepository: MushroomFollowingRepository? = null,
    private val additivesRepository: AdditivesRepository? = null,
    private val measurementsRepository: MeasurementsRepository? = null,
    private val substratesRepository: SubstratesRepository? = null,
    private val stagesRepository: StagesRepository? = null
) : ViewModel() {

    private val substratesLiveData: MutableLiveData<Result<List<SubstrateVD?>>> =
        MutableLiveData()
    private val additivesLiveData: MutableLiveData<Result<List<AdditiveVD?>>> = MutableLiveData()
    private val mushroomGrowingEntitiesLiveData: MutableLiveData<Result<List<MushroomGrowingEntityVD?>>> =
        MutableLiveData()

    private val stagesLiveData: MutableLiveData<Result<List<StageVD?>>> =
        MutableLiveData()

    private val measurementsLiveData: MutableLiveData<Result<List<MeasurementVD?>>> =
        MutableLiveData()

    fun getAdditivesLiveData(): LiveData<Result<List<AdditiveVD?>>> {
        return additivesLiveData
    }

    fun getMushroomGrowingEntitiesLiveData(): LiveData<Result<List<MushroomGrowingEntityVD?>>> {
        return mushroomGrowingEntitiesLiveData
    }

    fun getSubstratesLiveData(): LiveData<Result<List<SubstrateVD?>>> {
        return substratesLiveData
    }

    fun getStagesLiveData(): LiveData<Result<List<StageVD?>>> {
        return stagesLiveData
    }
    fun getMeasurementsLiveData(): LiveData<Result<List<MeasurementVD?>>> {
        return measurementsLiveData
    }

    fun fetch() {
        viewModelScope.launch {

            launch {
                additivesRepository?.getAdditives()?.collect {
                    additivesLiveData.postValue(it)
                }
            }
            launch {
                mushroomFollowingRepository?.getMushroomGrowingEntities()?.collect {
                    mushroomGrowingEntitiesLiveData.postValue(it)
                }
            }
            launch {
                measurementsRepository?.getMeasurements()?.collect {
                    measurementsLiveData.postValue(it)
                }
            }
            launch {
                substratesRepository?.getSubstrates()?.collect {
                    substratesLiveData.postValue(it)
                }
            }
            launch {
                stagesRepository?.getStages()?.collect {
                    stagesLiveData.postValue(it)
                }
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