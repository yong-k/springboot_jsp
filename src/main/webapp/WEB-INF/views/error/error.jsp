<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>web</title>
    <script>
        /**
         * [[ errcode ]]
         * default: 예상치 못한 오류가 발생했습니다.
         * 1: 존재하지 않는 회원입니다.
         * 2: 시스템에 문제가 발생했습니다. 다시 시도해주세요.
         * */
        let errcode = "${errcode}";

        if (errcode == 1)
            message = "존재하지 않는 회원입니다.";
        else if (errcode == 2)
            message = "시스템에 문제가 발생했습니다. 다시 시도해주세요.";
        else
            message = "예상치 못한 오류가 발생했습니다.";

        alert(message);
        history.back();
    </script>
</head>
<body>
</body>
</html>