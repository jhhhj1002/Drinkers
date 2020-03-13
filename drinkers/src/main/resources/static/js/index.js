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











// 회원가입 제출 버튼 클릭시 php 를 통해 person.txt에 정보 저장후 폼 입력값초기화후 폼 안보이게
$("#submit").click(function () {
  var form = $("form")[1];
  // var formData = new FormData(form);
  var myid = document.getElementById('id').value;
  var mypass = document.getElementById('password').value;
  $.ajax({
    url : "index3.php",
    type : 'GET',
    data : {id:myid,pass:mypass},
    dataType: 'text',
    success : function(data) {
      document.getElementById('id').value = "";
      document.getElementById('password').value="";
      document.getElementById('mybirth').value="";
      document.getElementById('checkbox').checked = false;
      document.getElementById('checkmybirth').checked=false;
      document.getElementById('createaccount').style.display="none";
      alert("회원가입이 성공적으로 완료되었습니다!");

    }, // success
    error : function(xhr, status,data) {
      alert(xhr + " : " + status);
    }
  });
});

// 로그인 클릭시 main1.php 를 통해 person.txt 정보를 불러와서 정보가 일치하는지 확인
// 결과에따라 로그인 실패시 폼 입력값 초기화 , 성공시 main2 페이지로 이동
$("#login").click(function () {
  var form = $("form")[0];
  // var formData = new FormData(form);
  var myid = document.getElementById('my_id').value;
  var mypass = document.getElementById('my_pass').value;
  $.ajax({
    url : "./php/index.php", // url 내가ㅏ 수정 
    type : 'GET',
    data : {id:myid,pass:mypass},
    dataType: 'text',
    success : function(data) {
    	 alert(data);
      if(data.includes("패스워드")){
        alert(data);
        document.getElementById('my_id').value="";
        document.getElementById('my_pass').value="";
      }
      else if(data.includes("아이디")){
        alert(data);
        document.getElementById('my_id').value="";
        document.getElementById('my_pass').value="";
      }
      else{
    	 
        sessionStorage.setItem('myObj',document.getElementById('my_id').value);
        var myid = sessionStorage.getItem("myObj");
        window.location.replace('main.html');
      }
    }, // success
    error : function(xhr, status,data) {
      alert(xhr + " : " + status);
    }
  });
});


// 회원가입시 생년월일 체크시 실행되는 function 으로 미성년자이면 가입불가하다는 메시지와 함께 체크박스가 초기화 됨
function checkmyorder(){
  var year = document.getElementById('mybirth').valueAsDate.getFullYear();
  var month = document.getElementById('mybirth').valueAsDate.getMonth()+1;
  var date = document.getElementById('mybirth').valueAsDate.getDate();
  var today = new Date();
  if((today.getFullYear()-year) >= 19){
    if((today.getFullYear()-year) == 19){
      if((today.getMonth()+1-month) >= 0){
        if((today.getMonth()+1-month) == 0){
          if((today.getDate()- date) < 0){
            document.getElementById('checkmybirth').checked = false;
            alert("미성년자는 가입이 불가합니다.");
          }
        }
      }
      else{
        document.getElementById('checkmybirth').checked = false;
        alert("미성년자는 가입이 불가합니다.");
      }
    }
  }
  else {
    document.getElementById('checkmybirth').checked = false;
    alert("미성년자는 가입이 불가합니다.");
  }
}
