window.Kakao.init('0850eafbca907dd881e8620df6f527ac');
function secession() {
	Kakao.API.request({
    	url: '/v1/user/unlink',
    	success: function(response) {
    		console.log(response);
            window.location.href='http://192.168.4.43:5500/index.html'
			// window.location.href='http://192.168.4.43:5500/index.html'

    		//callback(); //연결끊기(탈퇴)성공시 서버에서 처리할 함수
    	},
    	fail: function(error) {
    		console.log('탈퇴 미완료')
    		console.log(error);
    	},
	});
};
$(function(){
    $('.kaka_logout').click(function(){
        alert('이용해주셔셔 감사합니다 ^.^')
    })
})



