package com.example.chuckle_app.di.modules

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides


@Module
class GlideModule {

    @Provides
    fun provideGlide(context: Context): RequestManager {
        return Glide.with(context)
    }
}