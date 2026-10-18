package com.codegym.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            BigDecimal first = parseOperand(request.getParameter("firstOperand"));
            BigDecimal second = parseOperand(request.getParameter("secondOperand"));
            String operator = request.getParameter("operator");

            BigDecimal answer = Calculator.calculate(first, second, operator);
            String expression = format(first) + " " + operator + " " + format(second);
            request.setAttribute("expression", expression);
            request.setAttribute("message", "Kết quả: " + format(answer));
            request.setAttribute("isError", false);
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "Vui lòng nhập hai số hợp lệ.");
            request.setAttribute("isError", true);
        } catch (ArithmeticException | IllegalArgumentException ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("isError", true);
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private static BigDecimal parseOperand(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new NumberFormatException("Thiếu toán hạng");
        }
        return new BigDecimal(input.trim());
    }

    private static String format(BigDecimal value) {
        return value.stripTrailingZeros().toPlainString();
    }
}
