package com.cubetiqs.entize.clinical.helper

/**
 * Functions.kt
 * @ref: All Functions
 * @author Sambo Chea <sombochea@cubetiqs.com>
 */

import com.google.gson.Gson
import com.pusher.rest.Pusher
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Convert now date time to date or date time into string formatted.
 *
 * @param with_time Boolean
 * @return String
 */
fun nowFormatted(with_time: Boolean = false): String = DateTimeFormatter
        .ofPattern(if (with_time) "yyyy-MM-dd HH:mm:ss.SSSSSS" else "yyyy-MM-dd")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now())

/**
 * Now Formatted with default date without time.
 *
 * @return String
 */
fun nowFormatted2(): String = DateTimeFormatter
        .ofPattern("yyyy-MM-dd")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now())

/**
 * Format with date time in string to default date in string format with zone UTC.
 *
 * @param date String
 * @return String
 */
fun date(date: String): String = DateTimeFormatter
        .ofPattern("yyyy-MM-dd")
        .withZone(ZoneOffset.UTC)
        .format(LocalDate.parse(date))

/**
 * Format to default date.
 *
 * @param date String
 * @return Date
 */
fun Date.format(date: String): Date = date.toDate("yyyy-MM-dd")

/**
 * Get current date and time, when you call now().
 *
 * @return Date
 */
fun now(): Date = Date.from(Instant.now())

/**
 * Pusher Event for trigger channel and event name by this instance function.
 *
 * @return Pusher
 */
fun event(): Pusher = PusherService.instance

/**
 * Convert from object (S) to json string format.
 *
 * @param subject S
 * @return String
 */
inline fun <reified S> toJson(subject: S): String = GsonHelper.instance.toJson(subject)

/**
 * Convert from json string format to object (S).
 *
 * @param json String
 * @return S
 */
inline fun <reified S> fromJson(json: String): S =  GsonHelper.instance.fromJson(json, S::class.java)

inline fun <reified T: Any> Gson.fromJson(json: String, subject: T): T? = fromJson(json, T::class.java)