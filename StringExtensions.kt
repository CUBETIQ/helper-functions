package com.cubetiqs.entize.clinical.helper

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(format: String): Date = SimpleDateFormat(format).parse(this)