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
                <h3 class="main-header-info">회원 정보 수정</h3>
            </div>

            <form name="saveForm" action="/users/${user.id}" method="post">
                <div class="mb-3 row">
                     <label for="name" class="col-sm-2 col-form-label">이름</label>
                     <div class="col-sm-3">
                         <input type="text" class="form-control" id="name" name="name" value="${user.name}">
                     </div>
                 </div>
                 <div class="mb-3 row">
                     <label for="username" class="col-sm-2 col-form-label">닉네임<span class="form-required">*</span></label>
                     <div class="col-sm-3">
                         <input type="username" class="form-control" id="username" name="username" value="${user.username}">
                         <div class="errMsg" id="usernameErrMsg">이미 사용중인 닉네임 입니다.</div>
                     </div>
                 </div>
                <div class="mb-3 row">
                    <label for="password" class="col-sm-2 col-form-label">비밀번호<span class="form-required">*</span></label>
                    <div class="col-sm-3">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="password-check" class="col-sm-2 col-form-label">비밀번호 확인<span class="form-required">*</span></label>
                    <div class="col-sm-3">
                        <input type="password" class="form-control" id="password-check">
                        <div class="errMsg" id="passwordErrMsg">비밀번호가 일치하지 않습니다.</div>
                    </div>
                </div>
                 <div class="mb-3 row">
                     <label for="username" class="col-sm-2 col-form-label">이메일<span class="form-required">*</span></label>
                     <div class="col-sm-3">
                         <input type="email" class="form-control" id="email" name="email" value="${user.email}" placeholder="ex) abc123@naver.com">
                         <div class="errMsg" id="emailErrMsg">이미 사용중인 이메일 입니다.</div>
                     </div>
                 </div>
                 <div class="mb-3 row">
                     <label for="address" class="col-sm-2 col-form-label">주소</label>
                     <div class="col-sm-3">
                         <input type="address" class="form-control" id="address" name="address" value="${user.address}">
                     </div>
                 </div>
                 <div class="mb-3 row">
                     <label for="phone" class="col-sm-2 col-form-label">휴대폰</label>
                     <div class="col-sm-3">
                         <input type="phone" class="form-control" id="phone" name="phone" oninput="oninputPhone(this)" maxlength="13" placeholder="ex) 010-0000-0000">
                     </div>
                 </div>
                 <div class="mb-3 row">
                     <label for="company" class="col-sm-2 col-form-label">회사</label>
                     <div class="col-sm-3">
                         <input type="company" class="form-control" id="company" name="company" value="${user.company}">
                     </div>
                 </div>
                 <div class="mb-3 row">
                     <label for="website" class="col-sm-2 col-form-label">사이트</label>
                     <div class="col-sm-3">
                         <input type="text" class="form-control" id="website" name="website" value="${user.website}" placeholder="ex) www.naver.com">
                     </div>
                 </div>

                <div class="userform-btn-box">
                    <input type="hidden" name="_method" value="put">
                    <button id="saveBtn" type="button" class="btn btn-primary userform-btn">수정</button>
                    <div class="errMsg" id="requiredErrMsg">닉네임, 비밀번호, 이메일은 필수 입력 항목입니다.</div>
                </div>
                <input type="hidden" id="id" value="${user.id}">
            </form>
        </div>
    </div>

    <c:import url="/footer"></c:import>

    <script src="/js/userForm.js"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>