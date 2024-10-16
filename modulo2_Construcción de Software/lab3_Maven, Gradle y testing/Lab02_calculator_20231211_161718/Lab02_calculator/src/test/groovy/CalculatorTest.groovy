import spock.lang.Specification

class CalculatorTest extends Specification {

    def "addition test"() {
        given:
        Calculator calculator = new Calculator()

        expect:
        calculator.add(2, 3) == 5
    }

    def "subtraction test"() {
        given:
        Calculator calculator = new Calculator()

        expect:
        calculator.subtract(5, 3) == 2
    }

    def "multiplication test"() {
        given:
        Calculator calculator = new Calculator()

        expect:
        calculator.multiply(2, 3) == 6
    }

    def "division test"() {
        given:
        Calculator calculator = new Calculator()

        expect:
        calculator.divide(6, 2) == 3

        when:
        Throwable exception = null
        try {
            calculator.divide(6, 0)
        } catch (Throwable e) {
            exception = e
        }

        then:
        exception instanceof IllegalArgumentException
        exception.message == "Divider must not be zero."
    }

    def "check non-negative numbers"() {
        given:
        Calculator calculator = new Calculator()

        when:
        Throwable exception1 = null
        try {
            calculator.add(-1, 2)
        } catch (Throwable e) {
            exception1 = e
        }

        Throwable exception2 = null
        try {
            calculator.subtract(5, -3)
        } catch (Throwable e) {
            exception2 = e
        }

        then:
        exception1 instanceof IllegalArgumentException
        exception1.message == "Numbers must not be negative."

        exception2 instanceof IllegalArgumentException
        exception2.message == "Numbers must not be negative."
    }

    def "check 3-digit limit for results"() {
        given:
        Calculator calculator = new Calculator()

        when:
        Throwable exception1 = null
        try {
            calculator.add(999, 1)
        } catch (Throwable e) {
            exception1 = e
        }

        Throwable exception2 = null
        try {
            calculator.multiply(100, 10)
        } catch (Throwable e) {
            exception2 = e
        }

        then:
        exception1 instanceof IllegalArgumentException
        exception1.message == "Result must have at most 3 digits."

        exception2 instanceof IllegalArgumentException
        exception2.message == "Result must have at most 3 digits."
    }
}
