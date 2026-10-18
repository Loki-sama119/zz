import com.codegym.calculator.Calculator;
import java.math.BigDecimal;

public class CalculatorSmokeTest {
    public static void main(String[] args) {
        eq("12", Calculator.calculate(new BigDecimal("7"), new BigDecimal("5"), "+"));
        eq("2", Calculator.calculate(new BigDecimal("7"), new BigDecimal("5"), "-"));
        eq("35", Calculator.calculate(new BigDecimal("7"), new BigDecimal("5"), "*"));
        eq("2.5", Calculator.calculate(new BigDecimal("5"), new BigDecimal("2"), "/"));
        eq("0.3", Calculator.calculate(new BigDecimal("0.1"), new BigDecimal("0.2"), "+"));
        try {
            Calculator.calculate(new BigDecimal("5"), BigDecimal.ZERO, "/");
            throw new AssertionError("Phải phát hiện chia cho 0");
        } catch (ArithmeticException expected) { /* passed */ }
        try {
            Calculator.calculate(BigDecimal.ONE, BigDecimal.ONE, "?");
            throw new AssertionError("Phải từ chối phép toán không hợp lệ");
        } catch (IllegalArgumentException expected) { /* passed */ }
        System.out.println("PASS: 7 test cases (add/subtract/multiply/divide/decimal/zero/unknown-op)");
    }

    private static void eq(String expected, BigDecimal actual) {
        if (new BigDecimal(expected).compareTo(actual) != 0) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }
}
