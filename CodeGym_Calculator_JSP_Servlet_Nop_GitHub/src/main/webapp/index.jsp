<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Calculator - CodeGym</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles.css">
</head>
<body>
    <main class="calculator-card">
        <div class="eyebrow">JAVA WEB · JSP &amp; SERVLET</div>
        <h1>Ứng dụng Calculator</h1>
        <p class="lead">Nhập hai toán hạng, chọn phép tính và nhấn <strong>Tính kết quả</strong>.</p>

        <form action="${pageContext.request.contextPath}/calculate" method="post">
            <label for="firstOperand">Toán hạng thứ nhất</label>
            <input id="firstOperand" name="firstOperand" type="number" step="any"
                   placeholder="Ví dụ: 12.5" required autofocus>

            <label for="operator">Phép toán</label>
            <select id="operator" name="operator" required>
                <option value="+">Cộng (+)</option>
                <option value="-">Trừ (-)</option>
                <option value="*">Nhân (×)</option>
                <option value="/">Chia (÷)</option>
            </select>

            <label for="secondOperand">Toán hạng thứ hai</label>
            <input id="secondOperand" name="secondOperand" type="number" step="any"
                   placeholder="Ví dụ: 3" required>

            <button type="submit">Tính kết quả <span aria-hidden="true">→</span></button>
        </form>
        <p class="note">Có kiểm tra dữ liệu không hợp lệ và lỗi chia cho 0.</p>
    </main>
</body>
</html>
