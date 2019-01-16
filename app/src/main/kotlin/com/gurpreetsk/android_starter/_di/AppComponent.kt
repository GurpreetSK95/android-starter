package com.gurpreetsk.android_starter._di

import android.content.Context
import com.gurpreetsk.android_starter.MainApplication
import com.gurpreetsk.android_starter._http.StarterApi
import com.gurpreetsk.android_starter._di.modules.AppModule
import com.gurpreetsk.android_starter._di.modules.LogModule
import com.gurpreetsk.android_starter._di.modules.NetworkModule
import com.gurpreetsk.android_starter._di.modules.StorageModule
import com.gurpreetsk.android_starter.storage.CachedRepository
import com.gurpreetsk.android_starter.storage.LocalRepository
import com.gurpreetsk.android_starter.storage.db.AppDatabase
import com.gurpreetsk.android_starter.storage.prefs.AppSettings
import dagger.Component
import timber.log.Timber
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AppModule::class,
  LogModule::class,
  NetworkModule::class,
  StorageModule::class
]) interface AppComponent {
  fun timberTree(): Timber.Tree

  fun appDatabase(): AppDatabase
  fun appSettings(): AppSettings
  fun localRepository(): LocalRepository
  fun cachedRepository(): CachedRepository

  fun apiService(): StarterApi

  companion object {
    fun obtain(context: Context): AppComponent =
        (context.applicationContext as MainApplication).component()
  }
}
