let deleteBtn = document.getElementById("deleteBtn");
deleteBtn.onclick = () => {
    let response = confirm("삭제하시겠습니까?");
    if (response) {
        document.forms["deleteForm"].submit();
    }
};