// 숫자만, 점수=0~100사이, 학번=5자리
$(document).ready(function(){
    $("button").on("click", function(){
    console.log("click");
        if($('input[id="studentNo"]').val().length == 0){ // if( $('#id').val() == "" ) 도 가능
                alert('학생 번호가 입력되지 않았습니다!');
                $('input[id="studentNo"]').focus();
                return false;
            };
            if( isNaN($('input').val()) ){
                alert('숫자만 입력 가능합니다.');
                $('input').select();
                $(this).next().removeClass('hidden');
                return false;
            };
            let input = $('input').val();
            if( $.trim(input).length == 0 ){ // trim 은 문자열 맨앞, 맨 뒤에 있는 공백을 지우는데 이걸 사용한 이유는 공백만 입력한 경우도 통과 못하게 하기 위함
                alert('누락된 정보가 있습니다.');
                $(this).focus();
                $(this).next().removeClass('hidden');
                return false;
            };
    })
})
