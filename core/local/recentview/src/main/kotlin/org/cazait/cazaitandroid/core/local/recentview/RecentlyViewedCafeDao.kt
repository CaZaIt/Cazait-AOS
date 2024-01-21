package org.cazait.cazaitandroid.core.local.recentview

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import org.cazait.cazaitandroid.core.local.recentview.model.CafeEntity
import java.util.UUID

@Dao
interface RecentlyViewedCafeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecentlyViewedCafe(cafe: CafeEntity)

    @Query("SELECT * FROM CafeEntity")
    suspend fun getAllRecentlyViewedCafes(): List<CafeEntity>

    @Query("SELECT * FROM CafeEntity WHERE id = :cafeId")
    fun findRecentlyViewedCafeById(cafeId: UUID): CafeEntity

    @Query("SELECT * FROM CafeEntity ORDER BY storedDate DESC")
    suspend fun sortByDate(): List<CafeEntity>

    @Query("SELECT COUNT(id) FROM CafeEntity")
    suspend fun getRecentlyViewedCafeCount(): Int

    @Query("DELETE FROM CafeEntity WHERE storedDate = (SELECT MIN(storedDate) FROM CafeEntity)")
    suspend fun deleteOldestCafe()

    @Update
    suspend fun updateRecentlyViewedCafe(cafe: CafeEntity)

    @Delete
    suspend fun deleteRecentlyViewedCafe(cafe: CafeEntity)

    suspend fun addRecentlyViewedCafeWithLimit(cafe: CafeEntity) {
        if (getRecentlyViewedCafeCount() >= MAX_COUNT) {
            deleteOldestCafe()
        }
        addRecentlyViewedCafe(cafe)
    }

    companion object {
        private const val MAX_COUNT = 100
    }
}
