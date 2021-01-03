package com.vtchkn.mushroomfollowing

import android.app.Application
import android.content.Intent
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.vtchkn.mushroomfollowing.repository.MushroomFollowingRepository
import com.vtchkn.mushroomfollowing.repository.model.MushroomGrowingEntity
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val data = MutableLiveData<List<MushroomGrowingEntity>>()


    fun fetch() {
        viewModelScope.launch {
            if (isSignedIn()){
                MushroomFollowingRepository().getMushroomGrowingEntities()
            }
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
        return FirebaseAuth.getInstance().currentUser == null
    }
}