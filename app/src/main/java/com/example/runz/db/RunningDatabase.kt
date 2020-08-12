package com.example.runz.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Run::class],
    version = 1
)
abstract class RunningDatabase: RoomDatabase(){

    @TypeConverters(Converters::class)
    abstract fun getRunDao(): RunDAO
}