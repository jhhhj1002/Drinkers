
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





//업로드 폼을 통한 레시피 submit
//php에 연결하여 데이터를 전송후 폼창을 초기화 하고 보이지 않게 바꾼후 지금 업로드된 레시피 명과 대표사진을 메인페이지에 추가한다
function add(){
var form = $("form")[0];
var formData = new FormData(form);
$.ajax({
 cache : false,
 url : "upload.php",
 processData: false,
 contentType: false,
 type : 'POST',
 data : formData,
 dataType: 'text',
 success : function(data) {
   var recipeform =document.getElementById("Recipe");
   var recipe_name = document.getElementById('recipename').value;
   var imgInput = document.getElementById("selected_img");
   document.getElementById('recipename').value="";
   document.getElementById("upload_vedio").value="";
   document.getElementById("recipe_textarea").value="";
   recipeform.style.display='none';
   var figure = document.createElement('figure');
   figure.addEventListener("click", move);
   figure.id= recipe_name;
   var image = document.createElement('img');
   image.src = recipe_name+"/"+imgInput.files[0].name;
   figure.appendChild(image);
   var figcaption = document.createElement('figcaption');
   var recipe_name_node = document.createTextNode(recipe_name);
   figcaption.appendChild(recipe_name_node);
   figure.appendChild(figcaption);
   document.getElementById("selected_img").value="";
   document.getElementById('image').appendChild(figure);
 }, // success
 error : function(xhr, status,data) {
   alert(xhr + " : " + status);
 }
});
}

// recipenames.txt 를 통해서 현재 업로드되어있는 레시피명들을 가지고 오고 그레시피의 대표사진을 가지고와서
// 메인페이지에 출력한다
function readTextFile(file) {
  var rawFile = new XMLHttpRequest();
  rawFile.open("GET", file);
  rawFile.onreadystatechange = function () {
    if(rawFile.readyState === 4) { if(rawFile.status === 200 || rawFile.status == 0) {
      var allText = rawFile.responseText;
      var arrays = allText.toString().split("\n");
      var count=0;
      var my  = new Array();

      for(i in arrays) {
        if(arrays[i]!=""){
          var mydata = arrays[i].toString().split("|");
          var figure = document.createElement('figure');
          figure.addEventListener("click", move);
          figure.id= mydata[0];
          var image = document.createElement('img');
          image.src = mydata[0]+"/"+mydata[1];
          figure.appendChild(image);
          var figcaption = document.createElement('figcaption');
          var recipe_name_node = document.createTextNode(mydata[0]);
          figcaption.appendChild(recipe_name_node);
          figure.appendChild(figcaption);
          document.getElementById('image').appendChild(figure);
        }
      }
    }
    }
  };
  rawFile.send(null);
}

// 페이지 로드시 recipenames.txt 를 통해서 현재 업로드되어있는 레시피들을 가지고와서 메인페이지에 출력
$(function(){
    readTextFile("recipenames.txt");
});

// 최신순 클릭시 정렬
$("#last").click(function () {
  document.getElementById('image').innerHTML="";
  readTextFile("recipenames.txt");
});

// recipenames.txt 를 통해서 현재 업로드되어있는 레시피 명들을 가지고 오고 localStorage에 저장된 추천수들을 가져와서
// 추천순으로 메인페이지에 재정렬한다
function readTextFile_sort(file) {
  var rawFile = new XMLHttpRequest();
  rawFile.open("GET", file);
  rawFile.onreadystatechange = function () {
    if(rawFile.readyState === 4) { if(rawFile.status === 200 || rawFile.status == 0) {
      var allText = rawFile.responseText;
      var arrays = allText.toString().split("\n");
      var reco = new Array();
      var num=0;
      for(i in arrays) {
        if(arrays[i]!=""){
          var mydata = arrays[i].toString().split("|");
          reco[num] = new Array(mydata[0],mydata[1],localStorage[mydata[0]]);
          num++;
        }
      }
      reco.sort(function(a, b) {
          return b[2] - a[2];
      });

      for(i in reco){
        var figure = document.createElement('figure');
        figure.addEventListener("click", move);
        figure.id= reco[i][0];
        var image = document.createElement('img');
        image.src = reco[i][0]+"/"+reco[i][1];
        figure.appendChild(image);
        var figcaption = document.createElement('figcaption');
        var recipe_name_node = document.createTextNode(reco[i][0]);
        figcaption.appendChild(recipe_name_node);
        figure.appendChild(figcaption);
        document.getElementById('image').appendChild(figure);
      }
    }
    }
  };
  rawFile.send(null);
}

// 추천순 버튼 클릭시 추천순으로 정렬
$("#recommend").click(function () {
  document.getElementById('image').innerHTML="";
  readTextFile_sort("recipenames.txt");
});

// 메인화면에 있는 레시피 대표 이미지클릭시 detail html 로 넘어간다
function move(){
  if (window.sessionStorage) {
    sessionStorage.setItem('recipedetail_name',this.getAttribute("id"));
  }
  window.location.replace('food_detail.html');
}



//// upload 하는 폼에서 close 버튼을 누르면 입력했던 값들이 초기화되며 폼이 사라짐
//$("#close_modal").click(function () {
//  document.getElementById("selected_img").value="";
//  document.getElementById('recipename').value="";
//  document.getElementById("upload_vedio").value="";
//  document.getElementById("recipe_textarea").value="";
//  document.getElementById("Recipe").style.display="none";
//});
