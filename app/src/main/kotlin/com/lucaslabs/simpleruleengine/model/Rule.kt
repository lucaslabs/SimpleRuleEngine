package com.lucaslabs.simpleruleengine.model

data class Rule(
    val field: String,
    val operator: String,
    val valueType: String,
    val value: String,
)