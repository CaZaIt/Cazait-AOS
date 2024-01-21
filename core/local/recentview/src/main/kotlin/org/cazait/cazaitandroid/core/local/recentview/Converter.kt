package org.cazait.cazaitandroid.core.local.recentview

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date

internal class CafeImagesConverter {
    @TypeConverter
    fun fromCafeImages(images: List<String>): String {
        return Json.encodeToString(images)
    }

    @TypeConverter
    fun toCafeImages(serializedImages: String): List<String> {
        return Json.decodeFromString<List<String>>(serializedImages)
    }
}

internal class DateConverter {
    @TypeConverter
    fun toDate(timeStamp: String): Date {
        return DateUtil.dbDateFormat.parse(timeStamp) as Date
    }

    @TypeConverter
    fun toTimeStamp(date: Date): String {
        return DateUtil.dbDateFormat.format(date)
    }
}
