$(function(){
    $(window).scroll(function(){
        let pos = $(this).scrollTop();
        if(pos>0){
           $('.intr_pic1').css('animation-name','gide1')
        }else if(pos<10) {
            $('.intr_pic1').css('animation-name','none')
        }
        if(pos>500){
            $('.intr_pic3').css('animation-name','gide2')
            $('.intr_pic2').css('animation-name','gide2')
         }else if(pos<600) {
             $('.intr_pic2').css('animation-name','none')
             $('.intr_pic3').css('animation-name','none')
         }
         console.log(pos)
    })
    let index;
    $('.selected').click(function(){
        $('.answe2').slideUp()
        $('.answe3').slideUp()
        $('.answe4').slideUp()
        $('.answe5').slideUp()
        $('.answe').slideToggle('slow')
    })
    $('.selected2').click(function(){
        $('.answe2').slideToggle('slow')
        $('.answe').slideUp()
        $('.answe3').slideUp()
        $('.answe4').slideUp()
        $('.answe5').slideUp()
    })
    $('.selected3').click(function(){
        $('.answe3').slideToggle('slow')
        $('.answe').slideUp()
        $('.answe2').slideUp()
        $('.answe4').slideUp()
        $('.answe5').slideUp()
    })
    $('.selected4').click(function(){
        $('.answe4').slideToggle('slow')
        $('.answe').slideUp()
        $('.answe2').slideUp()
        $('.answe3').slideUp()
        $('.answe5').slideUp()
    })
    $('.selected5').click(function(){
        $('.answe5').slideToggle('slow')
        $('.answe').slideUp()
        $('.answe2').slideUp()
        $('.answe3').slideUp()
        $('.answe4').slideUp()
    })
    
    })
