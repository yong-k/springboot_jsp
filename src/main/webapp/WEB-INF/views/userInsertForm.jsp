<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>web1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>

    <c:import url="/header"></c:import>

    <div class="main">
        <div class="container text-center userform-box">
            <div class="main-header">
                <h3 class="main-header-info">회원 등록</h3>
            </div>

            <form action="/users" method="post">
                <div class="mb-3 row">
                    <label for="name" class="col-sm-2 col-form-label">이름</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="username" class="col-sm-2 col-form-label">닉네임</label>
                    <div class="col-sm-3">
                        <input type="username" class="form-control" id="username" name="username">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
                    <div class="col-sm-3">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="username" class="col-sm-2 col-form-label">이메일</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" id="email" name="email">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="address" class="col-sm-2 col-form-label">주소</label>
                    <div class="col-sm-3">
                        <input type="address" class="form-control" id="address" name="address">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="phone" class="col-sm-2 col-form-label">휴대폰</label>
                    <div class="col-sm-3">
                        <input type="phone" class="form-control" id="phone" name="phone">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="company" class="col-sm-2 col-form-label">회사</label>
                    <div class="col-sm-3">
                        <input type="company" class="form-control" id="company" name="company">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="website" class="col-sm-2 col-form-label">사이트</label>
                    <div class="col-sm-3">
                        <input type="website" class="form-control" id="website" name="website">
                    </div>
                </div>

                <div class="userform-btn-box">
                    <button class="btn btn-primary userform-btn">등록</button>
                </div>
            </form>

        </div>
    </div>

    <c:import url="/footer"></c:import>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>