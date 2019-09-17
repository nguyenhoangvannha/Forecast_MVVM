package com.nhvn.forecastmvvm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nhvn.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.nhvn.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.nhvn.forecastmvvm.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.nhvn.forecastmvvm.data.db.unitlocalized.MetricCurrentWeatherEntry

/**
 * Author: NGUYENHOANGVANNHA
 * Date: 9/17/2019
 * Project: Forecast MVVM
 */

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}