package com.example.jetpackcomposeplayground


data class MyFile(
    val title: String,
    val path: String,
    val isExist: Boolean,
    val isFavorite: Boolean,
    val isRecent: Boolean,
    val size: Long
) {
    override fun equals(other: Any?): Boolean {
        val ot = other as MyFile
        return (title == ot.title)

    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + path.hashCode()
        result = 31 * result + isExist.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + isRecent.hashCode()
        result = 31 * result + size.hashCode()
        return result
    }
}


