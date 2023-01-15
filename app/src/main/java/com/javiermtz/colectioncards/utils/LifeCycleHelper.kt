package com.javiermtz.colectioncards.utils

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LifeCycleHelper @Inject constructor(
    private val nameComponent: String
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun logOnCreate() {
        Log.i("LifecycleObserver $nameComponent ", "ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun logOnStart() {
        Log.i("LifecycleObserver $nameComponent ", "ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun logOnResume() {
        Log.i("LifecycleObserver $nameComponent ", "ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun logOnPause() {
        Log.i("LifecycleObserver $nameComponent ", "ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun logOnStop() {
        Log.i("LifecycleObserver $nameComponent ", "ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun logOnDestroy() {
        Log.i("LifecycleObserver $nameComponent ", "ON_DESTROY")
    }
//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    fun manageStates() {
//        if (lifecycle.currentState.isAtLeast(STARTED)) {
//            Log.i(nameComponent, "Current State ${lifecycle.currentState}")
//        }
//    }
}
