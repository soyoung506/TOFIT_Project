window.onload=function(){
  
//테스트용
// 세션 스토리지에서 "alertShown" 항목의 값을 가져옵니다.
var alertShown = sessionStorage.getItem("alertShown");

// "alertShown" 값이 "true"가 아닌 경우에만 alert를 실행합니다.
if (!alertShown) {
  alert("알림 메시지입니다.");
  
  // "alertShown" 값을 "true"로 설정하여 alert가 한 번 실행되었음을 저장합니다.
  sessionStorage.setItem("alertShown", "true");
}  
//테스트용



    $('.col_local input').click(function() {
        $('.col_local input').removeClass('selected');
        $(this).addClass('selected');  
      });
      
   
      //지역 클릭시 정보 div
     $('.col_local_all input').click(function() {
        $('.secSections').show();
    });

    $('.l_seoul input').click(function() {
        $('.secSections:not(.seoul)').hide();
        $('.seoul').show();
    });

    $('.l_busan input').click(function() {
        $('.secSections:not(.busan)').hide();
        $('.busan').show(); 
    });
    
    $('.l_inchun input').click(function() {
      $('.secSections:not(.inchun)').hide();
      $('.inchun').show(); 
  });

    $('.l_sejong input').click(function() {
      $('.secSections:not(.sejong)').hide();
      $('.sejong').show(); 
  });
  
    $('.l_gyung input').click(function() {
      $('.secSections:not(.gyung)').hide();
      $('.gyung').show(); 
  });
  
    $('.l_jeju input').click(function() {
      $('.secSections:not(.jeju)').hide();
      $('.jeju').show(); 
  });
  


      // 지역 클릭 영역
      /*  $('.col_local a').eq(1).on('click', function() {
          let localText = ['전체', '강남', '강동', '광진', '노원', '도봉'];
          $('.col_local2 a').each(function(index) {
            if (index <= 8) { 
              $(this).text(localText[index]);
              $(this).show();
            } else {
              $(this).hide();
            }
          });
        });
        
      $('.col_local a').eq(2).on('click', function() {
        var localText = ['전체', '해운대', '서면', '광안리'];
        $('.col_local2 a').each(function(index) {
          if (index <= 3) { 
            $(this).text(localText[index]);
            $(this).show();
          } else {
            $(this).hide();
          }
        });
      });
      $('.col_local a').eq(3).on('click', function() {
        var localText = ['전체', '인천중구', '연수구', '강화도'];
        $('.col_local2 a').each(function(index) {
          if (index <= 3) { 
            $(this).text(localText[index]);
            $(this).show();
          } else {
            $(this).hide();
          }
        });
      });
     
      $('.col_local a').eq(4).on('click', function() {
        $('.col_local2 a').each(function(index) {
          var localText = ['전체'];
          if (index <= 0) { 
            $(this).text(localText[index]);
            $(this).show();
          } else {
            $(this).hide();
          }
        });
     
      });
      $('.col_local a').eq(5).on('click', function() {
        $('.col_local2 a').each(function(index) {
          var localText = ['전체', '수원','의정부', '부천','남양주'];
          if (index <= 4) { 
            $(this).text(localText[index]);
            $(this).show();
          } else {
            $(this).hide();
          }
        });
      });
      $('.col_local a').eq(6).on('click', function() {
        $('.col_local2 a').each(function(index) {
          var localText = ['전체', '제주시', '서귀포시'];
          if (index <= 2) { 
            $(this).text(localText[index]);
            $(this).show();
          } else {
            $(this).hide();
          }
        });
      }); */
    // 지역 클릭 영역 끝

    
    

    
    const gogos = document.querySelectorAll('.gogogo');

    gogos.forEach(gogo => {
      gogo.addEventListener('click', function() {
        window.location.href = "more_center.html";
      });
    });

};