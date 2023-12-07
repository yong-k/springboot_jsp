fetch('desc').then(response => {
    let errorCode = response.status;
    if (errorCode == 404) {
        alert("요청하신 페이지를 찾을 수 없습니다.");
    } else {
        alert("오류가 발생했습니다.");
    }
    window.location="/users"
});