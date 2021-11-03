package com.lucaslabs.simpleruleengine.ruleengine

import com.lucaslabs.simpleruleengine.model.Rule
import com.lucaslabs.simpleruleengine.model.RuleSet

class RuleEngine {

    companion object {
        fun execute(ruleSet: RuleSet): Boolean {
            val conditions: List<Boolean> = ruleSet.rules.map { rule ->
                executeRule(rule)
            }

            return when (ruleSet.operator) {
                "and" -> conditions.reduce { acc, next -> acc && next }
                "or" -> conditions.reduce { acc, next -> acc || next }
                else -> conditions.first()
            }
        }

        private fun executeRule(rule: Rule): Boolean =
            when (rule.valueType) {
                "string" -> executeCondition(rule.field, rule.operator, rule.value)
                "int" -> executeCondition(rule.field.toInt(), rule.operator, rule.value.toInt())
                "float" -> executeCondition(
                    rule.field.toFloat(),
                    rule.operator,
                    rule.value.toFloat()
                )
                "boolean" -> executeCondition(
                    rule.field.toBoolean(),
                    rule.operator,
                    rule.value.toBoolean()
                )
                else -> throw Exception("Unhandled value type")
            }

        private fun executeCondition(field: String, operator: String, value: String): Boolean =
            when (operator) {
                "==" -> field == value
                "!=" -> field != value
                else -> throw Exception("Unhandled operator type")
            }

        private fun executeCondition(field: Int, operator: String, value: Int): Boolean =
            when (operator) {
                "==" -> field == value
                "!=" -> field != value
                ">" -> field > value
                ">=" -> field >= value
                "<" -> field < value
                "<=" -> field <= value
                else -> throw Exception("Unhandled operator type")
            }

        private fun executeCondition(field: Float, operator: String, value: Float): Boolean =
            when (operator) {
                "==" -> field == value
                "!=" -> field != value
                ">" -> field > value
                ">=" -> field >= value
                "<" -> field < value
                "<=" -> field <= value
                else -> throw Exception("Unhandled operator type")
            }

        private fun executeCondition(field: Boolean, operator: String, value: Boolean): Boolean =
            when (operator) {
                "==" -> field == value
                "!=" -> field != value
                "&&" -> field && value
                "||" -> field || value
                else -> throw Exception("Unhandled operator type")
            }
    }
}