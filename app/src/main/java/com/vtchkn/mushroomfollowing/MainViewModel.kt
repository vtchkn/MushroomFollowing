package com.vtchkn.mushroomfollowing

import android.app.Application
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.actionCodeSettings
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vtchkn.mushroomfollowing.repository.MushroomFollowingRepository
import com.vtchkn.mushroomfollowing.repository.model.MushroomGrowingEntity
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
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
            Build.VERSION.SDK_INT.toString() /* minimumVersion */)
    }


    fun fetch() {
        viewModelScope.launch {
//            if (isSignedIn()){
                MushroomFollowingRepository().getMushroomGrowingEntities()
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