package com.codegym.calculator;

import java.math.BigDecimal;
import java.math.MathContext;

/** Business logic: independent from Servlet/JSP. */
public final class Calculator {
    private Calculator() { }

    public static BigDecimal calculate(BigDecimal firstOperand,
                                       BigDecimal secondOperand,
                                       String operator) {
        if (firstOperand == null || secondOperand == null) {
            throw new IllegalArgumentException("Toán hạng không được để trống.");
        }
        if (operator == null) {
            throw new IllegalArgumentException("Vui lòng chọn phép toán.");
        }
        switch (operator) {
            case "+":
                return firstOperand.add(secondOperand);
            case "-":
                return firstOperand.subtract(secondOperand);
            case "*":
                return firstOperand.multiply(secondOperand);
            case "/":
                if (secondOperand.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Không thể chia cho 0.");
                }
                return firstOperand.divide(secondOperand, MathContext.DECIMAL64);
            default:
                throw new IllegalArgumentException("Phép toán không được hỗ trợ.");
        }
    }
}
