package com.vtchkn.mushroomfollowing.viewdata

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Long.parseTimeStamp() : Date? {
    val calendar = Calendar.getInstance()
    val tz = TimeZone.getDefault()
    calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.timeInMillis))
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    sdf.timeZone = tz
    val localTime = sdf.format(Date(this))

    var date: Date? = Date()
    try {
        date = sdf.parse(localTime)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return date
}
