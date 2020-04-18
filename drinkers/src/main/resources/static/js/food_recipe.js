// 업로드 버튼 클릭시 업로드 폼창 출력 & 숨김
function upload(){

  if ($("#recipe_upload").css("display") == "none") {
		jQuery('#recipe_upload').css("display", "block");
	} else {
		$("#recipe_upload_form")[0].reset();
		jQuery('#recipe_upload').css("display", "none");
	}
}

//upload 하는 폼에서 close 버튼 클릭시, form 값 reset & upload 폼 숨김
$("#close_modal").click(function () {
	$("#recipe_upload_form")[0].reset(); 
	jQuery('#recipe_upload').css("display", "none");
});

// 최신순 클릭시 재정렬
function lastest_order() {
	$.ajax({
		url : "do_lastest_order",
		type : 'GET',
		success : function(data) {
			$('#image').empty();
			
			$.each(data, function(index, item){				
				var temp = "<figure id='"+ item.title + "'>"
							+ "<a href=\"go_food_recipe_detail?title="+ item.title +"\">"
							+ "<img src=\"uploads/"+ item.title + "|"+ item.img +"\"> </a> "
							+ "<figcaption>"+ item.title +"</figcaption> </figure>";
			
				$('#image').append(temp);
			});			
		},
		error : function(xhr, status, data) {
			alert(xhr + " : " + status);
		}
	});
}

//추천순 클릭시 재정렬
function recommended_order() {
	
	var reco_arr = new Array();
	
	$.ajax({
		url : "do_lastest_order",
		type : 'GET',
		success : function(data) {
			
			$.each(data, function(index, item){	
				if (!localStorage[item.title]) {
					localStorage[item.title] = 0;
				}
				reco_arr[index] = new Array(item.title,item.img,localStorage[item.title]);
			});	
			
			reco_arr.sort(function(a, b) {
		        return b[2] - a[2];
		    });
			
			$('#image').empty();
			
			for(var i in reco_arr){
				 var temp = "<figure id='"+ reco_arr[i][0] + "'>"
					+ "<a href=\"go_food_recipe_detail?title="+ reco_arr[i][0] +"\">"
					+ "<img src=\"uploads/"+ reco_arr[i][0] + "|"+ reco_arr[i][1] +"\"> </a> "
					+ "<figcaption>"+ reco_arr[i][0] +"</figcaption> </figure>";
		
				 $('#image').append(temp);				 
			 }				
		},
		error : function(xhr, status, data) {
			alert(xhr + " : " + status);
		}
	});
}

