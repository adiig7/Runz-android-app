package com.example.runz.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsSortedByavgSpeedInKMH(): LiveData<List<Run>>

    @Query("SELECT  SUM(timestamp) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT  SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<List<Run>>



}