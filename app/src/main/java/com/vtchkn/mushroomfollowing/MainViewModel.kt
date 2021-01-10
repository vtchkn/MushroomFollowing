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

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val additivesLiveData: MutableLiveData<Result<List<AdditiveVD?>>> = MutableLiveData()
    fun getAdditivesLiveData(): LiveData<Result<List<AdditiveVD?>>> {
        return additivesLiveData
    }

    val data = MutableLiveData<List<MushroomGrowingEntity>>()
    val actionCodeSettings = actionCodeSettings {
        // URL you want to redirect back to. The domain (www.example.com) for this
        // URL must be whitelisted in the Firebase Console.
        url = "https://mushroomfollowing.page.link/redirect"
        // This must be true
        handleCodeInApp = true
        setAndroidPackageName(
            application.packageName,
            true, /* installIfNotAvailable */
            Build.VERSION.SDK_INT.toString() /* minimumVersion */
        )
    }

    @ExperimentalCoroutinesApi
    fun fetch() {
        viewModelScope.launch {
//            if (isSignedIn()){
            MushroomFollowingRepository().run {
//                    getMushroomGrowingEntities()
//                    getMeasurements()
                getAdditives()
//                    getSubstrates()
//                    getStages()
                getAdditives().collect {
                    additivesLiveData.postValue(it)
                }
            }
//            } else {
//                Firebase.auth.sendSignInLinkToEmail("zhhhh11@gmail.com", actionCodeSettings)
//                    .addOnCompleteListener { task ->
//                        if (task.isSuccessful) {
//                            Log.d("MainViewModel", "Email sent.")
//                        }
//                    }
//            }
        }
    }


    fun observeData(owner: LifecycleOwner, observer: Observer<List<MushroomGrowingEntity>>) {
        data.observe(owner, observer)
    }

    fun save(it: MushroomGrowingEntity) {
        viewModelScope.launch {

        }
    }

    private fun isSignedIn(): Boolean {
        return FirebaseAuth.getInstance().currentUser != null
    }
}