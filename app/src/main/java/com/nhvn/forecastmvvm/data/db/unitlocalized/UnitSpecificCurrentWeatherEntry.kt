package com.nhvn.forecastmvvm.data.db.unitlocalized

/**
 * Author: NGUYENHOANGVANNHA
 * Date: 9/17/2019
 * Project: Forecast MVVM
 */
interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}