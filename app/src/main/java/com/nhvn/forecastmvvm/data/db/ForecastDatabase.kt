package com.nhvn.forecastmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nhvn.forecastmvvm.data.db.dao.CurrentWeatherDao
import com.nhvn.forecastmvvm.data.db.entity.CurrentWeatherEntry

/**
 * Author: NGUYENHOANGVANNHA
 * Date: 9/17/2019
 * Project: Forecast MVVM
 */

@Database(entities = [CurrentWeatherEntry::class], version = 1)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile
        private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDataBase(context).also {
                instance = it;
            }
        }

        private fun buildDataBase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ForecastDatabase::class.java, "forecast.db"
        ).build()
    }
}