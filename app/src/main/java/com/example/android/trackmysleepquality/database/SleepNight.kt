package com.example.android.trackmysleepquality.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// da roomdb može kreirati tablicu (Entity),
// nastavak (tableName) je opcionalan da roomdb drugačije nazove tablicu,
// inače bi bilo kao i naziv klase
@Entity (tableName = "daily_sleep_quelity_table")
data class SleepNight (
    // primary key je obavezan
    @PrimaryKey (autoGenerate = true)
    var nightId: Long = 0L,

    @ColumnInfo (name="start_time_milli")
    val startTimeMili: Long = System.currentTimeMillis(),

    @ColumnInfo (name = "end_time_milli")
    var enrTimeMilli: Long = startTimeMili,

    @ColumnInfo (name = "quality_rating")
    var sleepQuality: Int = -1
)
