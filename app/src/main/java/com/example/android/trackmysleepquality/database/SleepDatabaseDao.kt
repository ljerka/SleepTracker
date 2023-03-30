package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao {
    /*
    All the functions declared inside the SleepDatabaseDao interface should be declared as suspend,
    except the one which returns a LiveData. The feature of a suspend function is that it can
    suspend the execution (pause and resume at a later time) of a coroutine.
     */

    @Insert
    suspend fun insert(night: SleepNight)

    @Update
    suspend fun update(night: SleepNight)

    @Query ("SELECT * from daily_sleep_quelity_table WHERE nightId = :key")
    suspend fun get(key: Long): SleepNight

    @Query ("DELETE FROM daily_sleep_quelity_table")
    suspend fun clear()

    @Query ("SELECT * FROM daily_sleep_quelity_table ORDER BY nightId DESC")
    fun getAllNights() : LiveData<List<SleepNight>>

    @Query ("SELECT * FROM daily_sleep_quelity_table ORDER BY nightId DESC LIMIT 1")
    suspend fun getTonight(): SleepNight?

    /*
    @Delete
    fun delete(night: SleepNight) // možemo brisati 1 po 1
    fun deleteMoreNights(nights: List<SleepNight>): Int // možemo brisati listu
     */
}
