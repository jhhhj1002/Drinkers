
// 페이지 로드시 마다 업로드했던 정보 동적으로 가져와서 출력
window.onload = function() {
	var recipedetail_name = $('#recipename').text();
	if (!localStorage[recipedetail_name]) {
		localStorage[recipedetail_name] = 0;
	}
	$('#reco_num').text(localStorage[recipedetail_name]);
}

// 추천버튼 누를때 레시피 명에 대한 localStorage에 숫자 1증가해서 저장후 메시지 출력, 현재 추천수 수정
function recommand_Add() {
	if (typeof (Storage) !== "undefined") {
		var recipedetail_name = $('#recipename').text();
		localStorage[recipedetail_name] = Number(localStorage[recipedetail_name]) + 1;
		alert("추천 감사드립니다");
		$('#reco_num').text(localStorage[recipedetail_name]);
	}
}

