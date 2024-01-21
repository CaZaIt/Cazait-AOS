package org.cazait.cazaitandroid.core.local.recentview

import java.text.SimpleDateFormat
import java.util.Locale

internal object DateUtil {
    val dbDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
}
