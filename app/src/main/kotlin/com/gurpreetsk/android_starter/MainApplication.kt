package com.gurpreetsk.android_starter

import android.annotation.SuppressLint
import android.app.Application
import com.gurpreetsk.android_starter._di.AppComponent
import com.gurpreetsk.android_starter._di.DaggerAppComponent
import com.gurpreetsk.android_starter._di.modules.AppModule
import timber.log.Timber

@SuppressLint("Registered")
open class MainApplication : Application() {
  private lateinit var component: AppComponent

  override fun onCreate() {
    super.onCreate()

    component = setupDependencyInjection()
    setupLibraries()

    Timber.i("Open sesame! Application initialized…")
  }

  private fun setupLibraries() {
    Timber.plant(component.timberTree())
  }

  fun component(): AppComponent = component

  open fun setupDependencyInjection() : AppComponent = DaggerAppComponent.builder()
      .appModule(AppModule(this))
      .build()
}
