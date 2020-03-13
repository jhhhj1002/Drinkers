// 회원가입 버튼 누를때 회원가입 창 폼 보이게 함
function show_form() {
	if ($("#create_account").css("display") == "none") {
		jQuery('#create_account').css("display", "block");
	} else {
		jQuery('#create_account').css("display", "none");
	}  
}
  
// 회원가입 폼에서 아이디 중복 확인 체크
function check_Id() {
	var userId = $("#account_id").val();

	$.ajax({
		url : "do_check_id",
		type : 'GET',
		data : {
			userId : userId
		},
		dataType : "text",
		success : function(data) {
			if (data.includes("true")) {
				alert("이미 사용중인 아이디 입니다.");
				$("input:checkbox[id='check_id']").prop("checked", false);
				$("#account_id").val("");
			} else {
				alert("사용 가능한 아이디 입니다.");
			}
		},
		error : function(xhr, status, data) {
			alert(xhr + " : " + status);
		}
	});

}

// 회원가입시 생년월일 체크시 실행되는 function 으로 미성년자이면 가입불가하다는 메시지와 함께 체크박스가 초기화 됨
function check_birth() {

	var mybirth = $("#mybirth").val();
	var date = mybirth.split("-");
	var today = new Date();
	
	if(mybirth == ""){
		$("#check_mybirth").prop("checked", false);
		alert("생년월일을 선택하세요.");
	}
	else if ($("#check_mybirth").prop("checked") == true) { // Check event
		if ((today.getFullYear() - date[0]) <= 19) {
			if ((today.getFullYear() - date[0]) == 19) {
				if ((today.getMonth() + 1 - date[1]) <= 0) {
					if ((today.getMonth() + 1 - date[1]) == 0) {
						if ((today.getDate() - date[2]) < 0) {
							$("#check_mybirth").prop("checked", false);
							alert("미성년자는 가입이 불가합니다.");
						}
					} else {
						$("#check_mybirth").prop("checked", false);
						alert("미성년자는 가입이 불가합니다.");
					}
				}
			} else {
				$("#check_mybirth").prop("checked", false);
				alert("미성년자는 가입이 불가합니다.");
			}
		}
	}
}

