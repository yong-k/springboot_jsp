<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>web</title>
    <script>
        let message = "${message}";
        if (message == "")
            message = "예상치 못한 에러가 발생했습니다.";
        alert(message);
        history.back();
    </script>
</head>
<body>
</body>
</html>