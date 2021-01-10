package com.vtchkn.mushroomfollowing

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.ktx.Firebase
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    companion object {
        const val TAG = "MainActivity"
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        viewModel.fetch()
        viewModel.getAdditivesLiveData().observe(this, Observer {
            when {
                it.isSuccess -> {
                    Log.d("isSuccess", it.getOrNull().toString())
                }
                it.isFailure -> {
                    Log.d("isFailure", it.getOrNull().toString())
                }
            }
        })

        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                // Get deep link from result (may be null if no link is found)
                var deepLink: Uri? = null
                if (pendingDynamicLinkData != null) {
                    deepLink = pendingDynamicLinkData.link
                }

                // Handle the deep link. For example, open the linked
                // content, or apply promotional credit to the user's
                // account.
                // ...

                // [START_EXCLUDE]
                // Display deep link in the UI
                if (deepLink != null) {
                    Snackbar.make(
                        findViewById(android.R.id.content),
                        "Found deep link!", Snackbar.LENGTH_LONG
                    ).show()

                    val auth = Firebase.auth
                    val intent = intent
                    val emailLink = intent.data.toString()

// Confirm the link is a sign-in with email link.
                    if (auth.isSignInWithEmailLink(emailLink)) {
                        // Retrieve this from wherever you stored it
                        val email = "zhhhh11@gmail.com"

                        // The client SDK will parse the code from the link for you.
                        auth.signInWithEmailLink(email, emailLink)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Log.d(TAG, "Successfully signed in with email link!")
                                    val result = task.result
                                    // You can access the new user via result.getUser()
                                    // Additional user info profile *not* available via:
                                    // result.getAdditionalUserInfo().getProfile() == null
                                    // You can check if the user is new or existing:
                                    // result.getAdditionalUserInfo().isNewUser()
                                    viewModel.fetch()
                                } else {
                                    Log.e(TAG, "Error signing in with email link", task.exception)
                                }
                            }
                    } else {
                        Log.d(TAG, "getDynamicLink: no link found")
                    }
                    // [END_EXCLUDE]
                }


            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }


    private fun updateUI(currentUser: FirebaseUser?) {

    }
}
