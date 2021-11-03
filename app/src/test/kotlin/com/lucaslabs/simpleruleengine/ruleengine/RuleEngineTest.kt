package com.lucaslabs.simpleruleengine.ruleengine

import com.lucaslabs.simpleruleengine.model.Rule
import com.lucaslabs.simpleruleengine.model.RuleSet
import org.junit.Assert.*
import org.junit.Test

class RuleEngineTest {

// TODO Define if we are using words, symbols or abbreviation for operators.
//    Operator list (name, symbol, abbreviation)
//    equal                 ==  eq
//    not equal             !=  ne
//    greater than	        >	gt
//    greater or equal than >=	ge
//    less than	            <	lt
//    less or equal than	<=	le
//    logical and	        &&	and
//    logical or	        ||	or

    // Value type string
    @Test
    fun `value type string with equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "value"
        val operator = "=="
        val value = "value"
        val valueType = "string"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type string with not equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "value1"
        val operator = "!="
        val value = "value2"
        val valueType = "string"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type string with not valid operator throw exception`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "value1"
        val operator = "==="
        val value = "value2"
        val valueType = "string"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val exception = runCatching {
            RuleEngine.execute(ruleSet)
        }.exceptionOrNull()

        // Then
        assertNotNull(exception)
        assertEquals(exception?.message, "Unhandled operator type")
    }

    // Value type int
    @Test
    fun `value type int with equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1"
        val operator = "=="
        val value = "1"
        val valueType = "int"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type int with not equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1"
        val operator = "!="
        val value = "2"
        val valueType = "int"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type int with greater than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "2"
        val operator = ">"
        val value = "1"
        val valueType = "int"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type int with greater or equal than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "2"
        val operator = ">="
        val value = "1"
        val valueType = "int"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type int with less than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1"
        val operator = "<"
        val value = "2"
        val valueType = "int"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type int with less or equal than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1"
        val operator = "<="
        val value = "2"
        val valueType = "int"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type int with not valid operator throw exception`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1"
        val operator = "==="
        val value = "1"
        val valueType = "int"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val exception = runCatching {
            RuleEngine.execute(ruleSet)
        }.exceptionOrNull()

        // Then
        assertNotNull(exception)
        assertEquals(exception?.message, "Unhandled operator type")
    }

    // Value type float
    @Test
    fun `value type float with equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1.0"
        val operator = "=="
        val value = "1.0"
        val valueType = "float"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type float with not equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1.0"
        val operator = "!="
        val value = "2.0"
        val valueType = "float"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type float with greater than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "2.0"
        val operator = ">"
        val value = "1.0"
        val valueType = "float"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type float with greater or equal than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "2.0"
        val operator = ">="
        val value = "1.0"
        val valueType = "float"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type float with less than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1.0"
        val operator = "<"
        val value = "2.0"
        val valueType = "float"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type float with less or equal than operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1.0"
        val operator = "<="
        val value = "2.0"
        val valueType = "float"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type float with not valid operator throw exception`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "1.0"
        val operator = "==="
        val value = "1.0"
        val valueType = "float"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val exception = runCatching {
            RuleEngine.execute(ruleSet)
        }.exceptionOrNull()

        // Then
        assertNotNull(exception)
        assertEquals(exception?.message, "Unhandled operator type")
    }

    // Value type boolean
    @Test
    fun `value type boolean with equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "true"
        val operator = "=="
        val value = "true"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type boolean with not equals operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "true"
        val operator = "!="
        val value = "false"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type boolean with and operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "true"
        val operator = "&&"
        val value = "true"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type boolean with and operator 2`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "true"
        val operator = "&&"
        val value = "false"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertFalse(result)
    }

    @Test
    fun `value type boolean with or operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "true"
        val operator = "||"
        val value = "true"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type boolean with or operator 2`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "true"
        val operator = "||"
        val value = "false"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    @Test
    fun `value type boolean with or operator 3`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "false"
        val operator = "||"
        val value = "false"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertFalse(result)
    }

    @Test
    fun `value type boolean with not valid operator throw exception`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val field = "true"
        val operator = "==="
        val value = "true"
        val valueType = "boolean"
        val rule = Rule(field, operator, valueType, value)
        ruleList.add(rule)

        val ruleSet = RuleSet(rules = ruleList)

        // When
        val exception = runCatching {
            RuleEngine.execute(ruleSet)
        }.exceptionOrNull()

        // Then
        assertNotNull(exception)
        assertEquals(exception?.message, "Unhandled operator type")
    }

    // Rule set with AND operator
    @Test
    fun `rule set with and operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val operator = "and"

        // Rule 1
        val field = "1" // amount
        val operator1 = ">"
        val value1 = "0"
        val valueType = "int"
        val rule1 = Rule(field, operator1, valueType, value1)
        ruleList.add(rule1)

        // Rule 2
        val operator2 = "<="
        val value2 = "100"
        val rule2 = Rule(field, operator2, valueType, value2)
        ruleList.add(rule2)

        val ruleSet = RuleSet(operator, ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }

    // Rule set with OR operator
    @Test
    fun `rule set with or operator`() {
        // Given
        val ruleList = mutableListOf<Rule>()

        val operator = "or"

        // Rule 1
        val field = "1" // amount
        val operator1 = "=="
        val value1 = "0"
        val valueType = "int"
        val rule1 = Rule(field, operator1, valueType, value1)
        ruleList.add(rule1)

        // Rule 2
        val operator2 = "<="
        val value2 = "100"
        val rule2 = Rule(field, operator2, valueType, value2)
        ruleList.add(rule2)

        val ruleSet = RuleSet(operator, ruleList)

        // When
        val result = RuleEngine.execute(ruleSet)

        // Then
        assertTrue(result)
    }
}