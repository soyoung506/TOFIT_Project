window.onload=function(){
    $(function(){
        $('.slider_panel').append($('.slider_image').first().clone()) 
        $('.slider_panel').prepend($('.slider_image').eq(-2).clone());
        let index=1;
        moveSlider(index);

        $('.left_control').click(function(){
            if(index>1){
                index--;
                moveSlider(index);
            }else{
                $('.slider_panel').css('left',-4152)
                index=5;
                moveSlider(index);
            }
        });
        $('.right_control').click(function(){
            if(index<5){ // 
                index++;
                moveSlider(index);
            }else{
                $('.slider_panel').css('left',0);
                index=1;
                moveSlider(index);
                
            }
        });

        function moveSlider(index){
            $('.slider_panel').stop(true).animate({
                left : -(index*692)  
            },'slow');
        }
    });

    $('a[rel="colorbox"]').colorbox({
        transition : 'fade',
        width:"75%",
        height:"75%",
        opacity:0.8,
   })
  
};