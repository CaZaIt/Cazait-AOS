package org.cazait.cazaitandroid.core.httphandle

class CazaitHttpException(
    message: String,
    val code: Int,
) : RuntimeException(message)
