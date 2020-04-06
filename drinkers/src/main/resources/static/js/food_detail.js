// innerHTML 다 바꾸기


// 페이지 로드시 마다 업로드했던 정보 동적으로 가져와서 출력
window.onload=function(){
   var recipedetail_name = $('#recipename').text();
   if (! localStorage[recipedetail_name]) {
	   localStorage[recipedetail_name]=0;
   }
   $('#reco_num').text(localStorage[recipedetail_name]);
}



// 업로드했던 레시피의 정보 중 사진을 가지고 와서 화면에 출력
// recipenames.txt을 통해서 레시피 명과 파일 명을 가지고오고 레시피명으로 된 폴더를 지정해서 사진을 불러올 수 있음
function readTextFile1(file) {
  var rawFile = new XMLHttpRequest();
  rawFile.open("GET", file);
  rawFile.onreadystatechange = function () {
    if(rawFile.readyState === 4) { if(rawFile.status === 200 || rawFile.status == 0) {
      var recipedetail_name = sessionStorage.getItem('recipedetail_name');
      var allText = rawFile.responseText;
      var arrays = allText.toString().split("\n");
      for(i in arrays) {
        if(arrays[i]!=""){
          var mydata = arrays[i].toString().split("|");
          if(mydata[0]==recipedetail_name){
            for(var k=1; k<mydata.length; k++){
              var image = document.createElement('img');
              image.src = mydata[0]+"/"+mydata[k];
              image.class = "img1";
              image.style.width="15vw";
              image.style.margin="1vw";
              image.style.height="18vw";
              document.getElementById('img').appendChild(image);
            }
            break;
          }
        }
      }
    }
    }
  };
  rawFile.send(null);
}

// 업로드 했던 정보중 동영상 주소와 레시피설명 text 를 가지고 와서 화면에 출력한다
// 레시피 명으로된 폴더안에 레시피 명.txt 에 주소와 text 정보 들어있음
function readTextFile2(file) {
  var rawFile = new XMLHttpRequest();
  rawFile.open("GET", file);
  rawFile.onreadystatechange = function () {
    if(rawFile.readyState === 4) { if(rawFile.status === 200 || rawFile.status == 0) {
      var allText = rawFile.responseText;
      var arrays = allText.toString().split("\n");
      for(i in arrays) {
        if(arrays[i]!=""){
          if(i==1){
            var iframe = document.createElement('iframe');
            iframe.src= arrays[1];
            iframe.id="YouTube";
            iframe.allowfullscreen;
            document.getElementById('YouTubediv').appendChild(iframe);
          }
          else if(i!=0){
            if(i==2){
              document.getElementById('textarea').innerHTML=arrays[2]+"\n";
            }
            else{
              document.getElementById('textarea').innerHTML += arrays[i]+"\n";
            }
          }
        }
      }
    }
    }
  };
  rawFile.send(null);
}

// 추천버튼 누를때 레시피 명에 대한 localStorage에 숫자 1증가해서 저장후 메시지 출력, 현재 추천수 수정
function recommandadd() {
  if (typeof(Storage) !== "undefined") {
    var recipedetail_name = sessionStorage.getItem('recipedetail_name');
    localStorage[recipedetail_name]= Number(localStorage[recipedetail_name])+1;
    alert("추천 감사드립니다");
    document.getElementById("reco_count").innerHTML = "현재추천수 : " + localStorage[recipedetail_name];
  }
}
