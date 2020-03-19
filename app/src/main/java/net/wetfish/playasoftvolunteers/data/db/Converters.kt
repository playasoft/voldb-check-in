package net.wetfish.playasoftvolunteers.data.db

import androidx.room.TypeConverter


/**
 * Created by ${Michael} on 9/25/2019.
 */

class Converters {
    @TypeConverter
    fun toList(strings: String): List<String> {
        val list = mutableListOf<String>()
        val array = strings.split(",")
        for (s in array) {
            list.add(s)
        }
        return list
    }

    @TypeConverter
    fun toString(strings: List<String>): String {
        var result = ""
        strings.forEachIndexed { index, element ->
            result += element
            if (index != (strings.size - 1)) {
                result += ","
            }
        }
        return result
    }
}
