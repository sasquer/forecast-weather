package com.sasquer.forecast.data.db.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities_table")
data class City(
    val cityId: Int,
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
