//header
window.onscroll = function() {myFunction()};

// Get the header
var header = document.getElementById("myHeader");

// Get the offset position of the navbar
var sticky = header.offsetTop;

// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
function myFunction() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
}


    function loginCheck(){
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;

    if(name == "") {
        alert("이름을 입력해주세요");
    } else if(email == "") {
        alert("이메일 주소를 입력해 주세요");
  
}
}
function loginCheck2(){
    let id = document.getElementById('id').value;
    let name = document.getElementById('name').value;
    let phone = document.getElementById('phone').value;

    if(id == "") {
        alert("아이디를 입력해주세요");
    } else if(name == "") {
        alert("이름을 입력해 주세요");
  	}else if(phone == "") {
	  alert("휴대폰 번호를 입력해주세요");
}
}


