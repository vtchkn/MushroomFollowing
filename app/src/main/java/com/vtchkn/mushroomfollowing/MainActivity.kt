package com.vtchkn.mushroomfollowing

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    companion object {
        const val TAG = "MainActivity"
    }

    private val viewModel: MainViewModel by viewModel()

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

    }


}
