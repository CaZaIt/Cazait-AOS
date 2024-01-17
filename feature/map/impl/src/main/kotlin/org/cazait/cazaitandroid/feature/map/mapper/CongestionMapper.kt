package org.cazait.cazaitandroid.feature.map.mapper

import androidx.annotation.StringRes
import org.cazait.cazaitandroid.core.repo.home.api.model.Congestion
import org.cazait.cazaitandroid.feature.map.R

@StringRes
internal fun Congestion.asStringRes(): Int = when (this) {
    Congestion.CLOSE -> R.string.close
    Congestion.FREE -> R.string.free
    Congestion.NORMAL -> R.string.normal
    Congestion.CROWDED -> R.string.crowded
    Congestion.VERY_CROWDED -> R.string.very_crowded
}
