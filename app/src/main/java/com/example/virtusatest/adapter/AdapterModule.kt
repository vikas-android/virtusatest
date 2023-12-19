package com.example.virtusatest.adapter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class AdapterModule {

    @Provides
    fun provideRecyclerAdapter():RecyclerAdapter{
        return RecyclerAdapter()
    }
}