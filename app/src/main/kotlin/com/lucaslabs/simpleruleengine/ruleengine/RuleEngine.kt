package com.lucaslabs.simpleruleengine.ruleengine

import com.lucaslabs.simpleruleengine.model.Rule
import com.lucaslabs.simpleruleengine.model.RuleSet

class RuleEngine {

    companion object {
        fun execute(ruleSet: RuleSet): Pair<Boolean, String> {
            val results: List<Pair<Boolean, String>> = ruleSet.rules.map { rule ->
                executeRule(rule)
            }

            val conditions: List<Boolean> = results.map { it.first }
            val error = results.firstOrNull { it.second.isNotEmpty() }?.second ?: ""

            val result = when (ruleSet.operator) {
                "and" -> conditions.reduce { acc, next -> acc && next }
                "or" -> conditions.reduce { acc, next -> acc || next }
                else -> conditions.first()
            }
            return Pair(result, error)
        }

        private fun executeRule(rule: Rule): Pair<Boolean, String> =
            when (rule.valueType) {
                "string" -> executeCondition(rule.value1, rule.operator, rule.value2, rule.error)
                "int" -> executeCondition(
                    rule.value1.toInt(),
                    rule.operator,
                    rule.value2.toInt(),
                    rule.error)
                "float" -> executeCondition(
                    rule.value1.toFloat(),
                    rule.operator,
                    rule.value2.toFloat(),
                    rule.error
                )
                "boolean" -> executeCondition(
                    rule.value1.toBoolean(),
                    rule.operator,
                    rule.value2.toBoolean(),
                    rule.error
                )
                else -> throw Exception("Unhandled value type")
            }

        private fun executeCondition(
            field: String,
            operator: String,
            value: String,
            error: String,
        ): Pair<Boolean, String> {
            val result = when (operator) {
                "==" -> field == value
                "!=" -> field != value
                else -> throw Exception("Unhandled operator type")
            }
            return Pair(result, if (!result) error else "")
        }

        private fun executeCondition(
            field: Int,
            operator: String,
            value: Int,
            error: String,
        ): Pair<Boolean, String> {
            val result = when (operator) {
                "==" -> field == value
                "!=" -> field != value
                ">" -> field > value
                ">=" -> field >= value
                "<" -> field < value
                "<=" -> field <= value
                else -> throw Exception("Unhandled operator type")
            }
            return Pair(result, if (!result) error else "")
        }

        private fun executeCondition(
            field: Float,
            operator: String,
            value: Float,
            error: String,
        ): Pair<Boolean, String> {
            val result = when (operator) {
                "==" -> field == value
                "!=" -> field != value
                ">" -> field > value
                ">=" -> field >= value
                "<" -> field < value
                "<=" -> field <= value
                else -> throw Exception("Unhandled operator type")
            }
            return Pair(result, if (!result) error else "")
        }

        private fun executeCondition(
            field: Boolean,
            operator: String,
            value: Boolean,
            error: String,
        ): Pair<Boolean, String> {
            val result = when (operator) {
                "==" -> field == value
                "!=" -> field != value
                "&&" -> field && value
                "||" -> field || value
                else -> throw Exception("Unhandled operator type")
            }
            return Pair(result, if (!result) error else "")
        }
    }
}