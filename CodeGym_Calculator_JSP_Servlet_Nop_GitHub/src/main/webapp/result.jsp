<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kết quả phép tính - CodeGym</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles.css">
</head>
<body>
    <main class="calculator-card">
        <div class="eyebrow">KẾT QUẢ · CALCULATOR SERVLET</div>
        <h1>${isError ? 'Thông báo lỗi' : 'Tính toán thành công'}</h1>
        <div class="result-box ${isError ? 'result-error' : 'result-success'}" role="status">
            <p class="expression">${expression}</p>
            <p class="answer">${message}</p>
        </div>
        <a class="back-link" href="${pageContext.request.contextPath}/">← Quay lại máy tính</a>
    </main>
</body>
</html>
