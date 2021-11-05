package com.lucaslabs.simpleruleengine.model

data class Rule(
    val value1: String,
    val operator: String,
    val valueType: String,
    val value2: String,
    val error: String
)