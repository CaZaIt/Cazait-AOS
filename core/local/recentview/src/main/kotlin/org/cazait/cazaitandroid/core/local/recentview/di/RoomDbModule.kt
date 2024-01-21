package org.cazait.cazaitandroid.core.local.recentview.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.cazait.cazaitandroid.core.local.recentview.CafeRoomDatabase
import org.cazait.cazaitandroid.core.local.recentview.RecentlyViewedCafeDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RoomDbModule {

    @Provides
    @Singleton
    fun provideCafeRoomDatabase(
        @ApplicationContext context: Context,
    ): CafeRoomDatabase {
        return Room.databaseBuilder(
            context,
            CafeRoomDatabase::class.java,
            "RecentlyViewedCafe",
        ).build()
    }

    @Provides
    @Singleton
    fun provideCafeDao(
        cafeRoomDatabase: CafeRoomDatabase,
    ): RecentlyViewedCafeDao {
        return cafeRoomDatabase.recentlyViewedCafeDao()
    }
}
