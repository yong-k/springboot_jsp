/*common*/

/*userDetail*/
let deleteBtn = document.getElementById("deleteBtn");
deleteBtn.onclick = () => {
    let response = confirm("삭제하시겠습니까?");
    if (response) {
        document.forms["deleteForm"].submit();
    }
};

/*insertForm*/

/*updateForm*/
let updateBtn = document.getElementById("updateBtn");
let name = document.getElementById("name");

updateBtn.onclick = () => {
    name.value = document.getElementById("name").value;

    document.forms["updateForm"].submit();
};