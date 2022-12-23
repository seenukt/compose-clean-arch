package com.example.cleanarchitecturecompose.presentation

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturecompose.CleanArchitectureApplication
import com.example.cleanarchitecturecompose.di.networkModule
import com.example.cleanarchitecturecompose.di.repositoryModule
import com.example.cleanarchitecturecompose.di.viewModelModule
import com.example.cleanarchitecturecompose.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.mockito.Mockito.mock
import java.util.concurrent.CountDownLatch


class MainActivityViewModelTest : KoinTest {

    private val vm: MainActivityViewModel by inject()
    private val dummyVm: DummyViewModel by inject()


    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(viewModelModule, repositoryModule, networkModule)
    }

    @get:Rule
    val rule = InstantTaskExecutorRule()




    @Before
    fun before() {
        MockKAnnotations.init(this)
    }


    @Test
    fun `return true email and password is not empty`() {
        vm.returnState("ssss", "sss")
        val value = vm.status.getOrAwaitValue()
        assertEquals(value, true)
    }

    @Test
    fun `return false when the email is empty`() {
        vm.returnState("", "sssss")
        assertEquals(vm.status.getOrAwaitValue(), false)

    }
    @Test
    fun `test the dummy data`() {
           dummyVm.getData()
           assert(dummyVm.listResponse.isSuccessful)
    }
}

