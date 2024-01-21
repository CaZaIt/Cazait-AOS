package org.cazait.cazaitandroid.core.local.recentview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class CafeEntity(
    @PrimaryKey(autoGenerate = false)
    val id: UUID,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val address: String,
    @ColumnInfo
    val cafeImages: List<String>,
    @ColumnInfo
    val latitude: Double,
    @ColumnInfo
    val longitude: Double,
    @ColumnInfo
    val storedDate: Date,
)
