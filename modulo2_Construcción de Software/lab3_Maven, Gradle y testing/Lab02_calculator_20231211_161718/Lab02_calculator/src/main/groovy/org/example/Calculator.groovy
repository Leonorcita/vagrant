class Calculator {
    int add(int a, int b) {
        checkNonNegative(a, b)
        int result = a + b
        checkResult(result)
        return result
    }

    int subtract(int a, int b) {
        checkNonNegative(a, b)
        int result = a - b
        checkResult(result)
        return result
    }

    int multiply(int a, int b) {
        checkNonNegative(a, b)
        int result = a * b
        checkResult(result)
        return result
    }

    int divide(int a, int b) {
        checkNonNegative(a, b)
        checkNonZero(b)
        int result = a / b
        checkResult(result)
        return result
    }

    private void checkNonNegative(int... values) {
        for (int value : values) {
            if (value < 0) {
                throw new IllegalArgumentException("Numbers must not be negative.")
            }
        }
    }

    private void checkNonZero(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("Divider must not be zero.")
        }
    }

    private void checkResult(int result) {
        if (result >= 1000 || result <= -1000) {
            throw new IllegalArgumentException("Result must have at most 3 digits.")
        }
    }
}
