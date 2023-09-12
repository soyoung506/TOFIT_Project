
    function loginCheck(){
    let frmLogin = document.frmLogin;
    let id = document.getElementById('inpud_id').value;
    let pw = document.getElementById('inpud_pw').value;

    if(id == "") {
        alert("아이디를 입력해주세요");
    } else if(pw == "") {
        alert("비밀번호를 입력해주세요")
    }else {
        frmLogin.submit();
    }
}

