package com.example.cleanarchitecturecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {

    private val vm: DummyViewModel by viewModel()
//    private lateinit var state: MutableState<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            state = remember { mutableStateOf(false) }
            initObserver()
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                Button(onClick = {
//                    vm.returnState("kts", "1233")
                    vm.getData()
                }) {
                    Text(text = "Click Me")
                }
//                if (state.value) {
//                    Text(text = " success")
//                } else {
//                    Text(text = " failed")
//                }
            }
        }
    }

    private fun initObserver() {

    }

//    private fun initObserver() {
//        vm.status.observe(this) {
//            state.value = it
//        }
//        vm.test.observe(this){
//            println("data $it")
//        }
//    }

}
