package org.cazait.cazaitandroid.core.local.recentview

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.cazait.cazaitandroid.core.local.recentview.model.CafeEntity

@Database(entities = [(CafeEntity::class)], version = 1, exportSchema = false)
@TypeConverters(
    CafeImagesConverter::class,
    DateConverter::class,
)
internal abstract class CafeRoomDatabase : RoomDatabase() {
    abstract fun recentlyViewedCafeDao(): RecentlyViewedCafeDao
}
