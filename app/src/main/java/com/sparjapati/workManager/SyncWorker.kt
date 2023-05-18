package com.sparjapati.workManager

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.lang.Exception


private const val TAG = "SyncWorker"

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted context: Context, @Assisted workerParams: WorkerParameters,
    private val api: NetworkApi
) : CoroutineWorker(
    context, workerParams
) {
    @SuppressLint("RestrictedApi")
    override suspend fun doWork(): Result {
        return try {
            val todo = api.getTodo()
            Log.d(TAG, "todo: $todo")
            val outputData = Data.Builder().putParcelable("todo",todo).build()
            Result.success(outputData)
        }catch (e: Exception){
            Log.d(TAG, "$e")
            Result.retry()
        }
    }
}
