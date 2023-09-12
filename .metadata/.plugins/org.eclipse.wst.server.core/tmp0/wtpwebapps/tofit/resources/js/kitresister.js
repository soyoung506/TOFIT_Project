function ck_email(){
  var email = document.getElementById("email")
  var MsgId = document.getElementById("MsgId")
  var isEmail = /([\w\-]+\@[\w\-]+\.[\w\-]+)/

  if(!isEmail.test(email.value)){
      MsgId.style.display="block";
      MsgId.className='error'
      MsgId.innerHTML="이메일 형식을 확인하세요"
      email.focus()
      return false;
  } else{
      MsgId.className='vaild'
      MsgId.innerHTML="ok"
  }   
}

function ck_pwd(){
  var pwd = document.getElementById("pwd")
  var MsgPw = document.getElementById("MsgPw")
  var isPwd = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/
  
  if(!isPwd.test(pwd.value)){
      MsgPw.style.display="block";
      MsgPw.className='error'
      MsgPw.innerHTML="숫자포함 최소 6자리 이상"
      pwd.focus()
      return false;
  } else{
      MsgPw.className='vaild'
      MsgPw.innerHTML="ok"
  }   
}


function ck_pwd2(){
  var pwd_ck = document.getElementById("pwd_ck")
  var pwd = document.getElementById("pwd").value
  var MsgPwck = document.getElementById("MsgPwck")
  
  if(pwd_ck.value!=pwd){
      MsgPwck.style.display="block";
      MsgPwck.className='error'
      MsgPwck.innerHTML="비밀번호가 일치하지 않습니다."
      pwd_ck.focus()
  
  } else{
      MsgPwck.className='vaild'
      MsgPwck.innerHTML="ok"
  }   
}


function ck_name(){
  var name = document.getElementById("name")
  var MsgName = document.getElementById("MsgName")
  
  if(name.value==''){
      MsgName.style.display="block";
      MsgName.className='error'
      MsgName.innerHTML="2자 이상 입력하세요."
      name.focus()
      return false;
  } else{
      MsgName.className='vaild'
      MsgName.innerHTML="ok"
  }   
}






/*    
if(man.checked == false && woman.checked == false){
  MsgGender.style.display="block";
  MsgGender.className='error'
  MsgGender.innerHTML="필수 정보입니다."        wrap_gender.style.borderColor="red";
  return false;
}
*/
