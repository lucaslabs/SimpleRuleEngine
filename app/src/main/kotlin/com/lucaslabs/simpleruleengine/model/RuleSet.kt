package com.lucaslabs.simpleruleengine.model

data class RuleSet(
    val operator: String = "",
    val rules: List<Rule>,
)