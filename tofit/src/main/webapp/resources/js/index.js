$(function(){
    $(window).scroll(function(){
        let pos = $(this).scrollTop();
        if(pos>400){
            $('.product_pig1').css('animation-name','jaehee')
            $('.product_pig2').css('animation-name','jaehe')
            $('.product_inner').css('animation-name','jaehe1')
            $('.box img').css('animation-name','jaehe2')
        }else if(pos<571) {
            $('.product_pig1').css('animation-name','')
            $('.product_pig2').css('animation-name','none')
            $('.product_inner').css('animation-name','none')
            $('.box img').css('animation-name','none')
        }
        let pos1 = $(this).scrollTop();
        if(pos1>1060){
            $('.box1_pic').css('animation-name','jaehe2')
            $('.box1').css('animation-name','jaehe3')
        }else if(pos1<1100) {
            $('.box1_pic').css('animation-name','none')
            $('.box1').css('animation-name','none')
        }
        let pos2 = $(this).scrollTop();
        if(pos2>1060){
            $('.graph').css('animation-name','jaehe4')
            $('.box2_pig1').css('animation-name','jaehe4')
            $('.box2').css('animation-name','jaehe5')
        }else if(pos2<1100) {
            $('.graph').css('animation-name','none')
            $('.box2_pig1').css('animation-name','none')
            $('.box2').css('animation-name','none')
        }
        console.log(pos2)

        let pos3 = $(this).scrollTop();
        if(pos3>800){
            $('.box3').css('animation-name','jaehe5')
            $('.box3_pig').css('animation-name','jaehe6')
            $('.box3_pig2').css('animation-name','jaehe7')
        }else if(pos3<900) {
            $('.box3').css('animation-name','none')
            $('.box3_pig').css('animation-name','none')
            $('.box3_pig2').css('animation-name','none')
        }
        let pos4 = $(this).scrollTop();
        if(pos4>1500){
            $('.program_box1').css('animation-name','jaehe10')
            $('.program_box2').css('animation-name','jaehe10')
            $('.program_btn1').css('animation-name','jaehe8')
            $('.program_btn2').css('animation-name','jaehe8')
            $('.program_pig2').css('animation-name','jaehe9')
            $('.program_pig2').css('animation-name','jaehe9')
        }else if(pos4<1700) {
            $('.program_box1').css('animation-name','none')
            $('.program_box2').css('animation-name','none')
            $('.program_btn1').css('animation-name','none')
            $('.program_btn2').css('animation-name','none')
            $('.program_pig2').css('animation-name','none')
            $('.program_pig2').css('animation-name','none')
        }
    })
        
    
})