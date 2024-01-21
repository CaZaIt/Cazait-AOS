package org.cazait.cazaitandroid.core.local.recentview

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.local.recentview.model.CafeEntity
import java.util.UUID

@Dao
interface RecentlyViewedCafeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecentlyViewedCafe(cafe: CafeEntity)

    @Query("SELECT * FROM CafeEntity")
    fun getAllRecentlyViewedCafes(): Flow<List<CafeEntity>>

    @Query("SELECT * FROM CafeEntity WHERE id = :cafeId")
    fun findRecentlyViewedCafeById(cafeId: UUID): CafeEntity

    @Query("SELECT * FROM CafeEntity ORDER BY storedDate DESC")
    fun sortByDate(): Flow<List<CafeEntity>>

    @Update
    suspend fun updateRecentlyViewedCafe(cafe: CafeEntity)

    @Delete
    suspend fun deleteRecentlyViewedCafe(cafe: CafeEntity)
}
