package com.sparjapati.workManager

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Todo(
	val id: Int,
	val completed: Boolean,
	val title: String,
	val userId: Int
): Parcelable
