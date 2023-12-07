let formBtn = document.getElementById("saveBtn");
let passCheck = false;

formBtn.onclick = () => {
    let id = $("#id").val();

    $("#usernameErrMsg").css("display", "none");
    $("#passwordErrMsg").css("display", "none");
    $("#emailErrMsg").css("display", "none");
    $("#requiredErrMsg").css("display", "none");

    // 필수항목 비어있는지 체크
    if ($("#username").val() == "" || $("#password").val() == "" || $("#password-check").val() == "" || $("#email").val() == "") {
        $("#requiredErrMsg").css("display", "block");
        return false;
    }

    // username, email : not null, unique
    // username 중복체크
    let username = $("#username").val().replaceAll(" ", "");
    $("#username").val(username);
    $.ajax({
        method: "POST",
        url: "/checkusername",
        data: {"id" : id, "username" : username},
        async: false
    })
    .done(function (response) {
        if (response > 0) {
            $("#usernameErrMsg").css("display", "block");
            $("#username").focus();
            passCheck = false;
        } else {
            passCheck = true;
        }
    })
    .fail(function (e) {
        console.log(e.status);
        console.log(e.responseText);
    });

    if (!passCheck) {
        return false;
    }

    // 비밀번호 == 비밀번호 확인
    if ($("#password").val() != $("#password-check").val()) {
        $("#passwordErrMsg").css("display", "block");
        $("#password-check").focus();
        return false;
    }

    // 이메일: 형식 맞는지 → 중복체크
    let email = $("#email").val();
    if (!isEmailFormat(email)) {
        $("#emailErrMsg").html("이메일 형식이 올바르지 않습니다.");
        $("#emailErrMsg").css("display", "block");
        $("#email").focus();
        passCheck = false;
    } else {
        $.ajax({
            method: "POST",
            url: "/checkemail",
            data: {"id" : id, "email" : email},
            async: false
        })
        .done(function (response) {
            if (response > 0) {
                $("#emailErrMsg").html("이미 사용중인 이메일입니다.");
                $("#emailErrMsg").css("display", "block");
                $("#email").focus();
                passCheck = false;
            } else {
                passCheck = true;
            }
        })
        .fail(function (e) {
            console.log(e.status);
            console.log(e.responseText);
        });
    }

    if (passCheck) {
        document.forms["saveForm"].submit();
    }
    return false;
};

function oninputPhone(phone) {
    phone.value = phone.value
            .replace(/[^0-9]/g, '')
            .replace(/(^02.{0}|^01.{1}|[0-9]{3,4})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
}

function isEmailFormat(email) {
    let format = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;
    if (format.test(email))
        return true;
    return false;
}