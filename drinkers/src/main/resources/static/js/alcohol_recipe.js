// 업로드 버튼 클릭시 모달창 보이게
function Upload_alcohol(){
  document.getElementById("Recipe").style.display="block";
}
// close 버튼클릭시 detail모달창 사라지게
function close_detail(){
  document.getElementById("recipe_detail").style.display="none";
}

// 레시피에대한 detail 을 보여줄때 "alcohol_recipenames.txt" 에 저장된 레시피 이름과 이미지 이름 찾아서 detail 창에 불러옴
function readTextFile1(file,name) {
  var rawFile = new XMLHttpRequest();
  rawFile.open("GET", file);
  rawFile.onreadystatechange = function () {
    if(rawFile.readyState === 4) { if(rawFile.status === 200 || rawFile.status == 0) {
      var allText = rawFile.responseText;
      var arrays = allText.toString().split("\n");
      for(i in arrays) {
        if(arrays[i]!=""){
          var mydata = arrays[i].toString().split("|");
          if(mydata[0]==name){
            for(var k=1; k<mydata.length; k++){
              var image = document.createElement('img');
              image.src = mydata[0]+"/"+mydata[k];
              document.getElementById('img'+k).appendChild(image);
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

// 레시피에대한 detail 을 보여줄때 레시피이름 폴더의 txt 파일에서 레시피text찾아서 detail 창에 불러옴
function readTextFile2(file,name) {
  var rawFile = new XMLHttpRequest();
  rawFile.open("GET", file);
  rawFile.onreadystatechange = function () {
    if(rawFile.readyState === 4) { if(rawFile.status === 200 || rawFile.status == 0) {
      var allText = rawFile.responseText;
      var arrays = allText.toString().split("\n");
      for(i in arrays) {
        if(arrays[i]!=""){
           if(i!=0){
            if(i==1){
              document.getElementById('textarea').innerHTML=arrays[1]+"\n";
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

// 레시피 대표사진 클릭시 레시피에관한 detail 보여주기
function show_detail(){
  document.getElementById('img1').innerHTML="";
  document.getElementById('img2').innerHTML="";
  document.getElementById('title').innerHTML=this.getAttribute('id');
  readTextFile1("alcohol_recipenames.txt",this.getAttribute('id'));
  var filename = this.getAttribute('id')+"/"+this.getAttribute('id')+".txt"
  readTextFile2(filename,this.getAttribute('id'));
  document.getElementById("recipe_detail").style.display="block";
}

// 레시피 upload 시 submit 할때의 동작
// 폼의 정보들을 php에 전송하고 폼을 초기화 하고 또한 figure태그를 통하여 메인화면에 레시피명과 대표이미지를 추가한다
function upload_item(){
  var form = $("form")[0];
  var formData = new FormData(form);
  $.ajax({
    cache : false,
    url : "upload_recipe.php",
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
      document.getElementById("recipe_textarea").value="";
      recipeform.style.display='none';
      var figure = document.createElement('figure');
      figure.addEventListener("click", show_detail);
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

// 페이지를 로드할때마다 업로드 했었던 정보 가지고와서 메인페이지에 정렬 하는 메소드로
// txt 파일을 읽어서 대표이미지와 레시피 명을 메인 페이지에 출력한다
function readTextFile(file) {
  var rawFile = new XMLHttpRequest();
  rawFile.open("GET", file);
  rawFile.onreadystatechange = function () {
    if(rawFile.readyState === 4) { if(rawFile.status === 200 || rawFile.status == 0) {
      var allText = rawFile.responseText;
      var arrays = allText.toString().split("\n");
      for(i in arrays) {
        if(arrays[i]!=""){
          var mydata = arrays[i].toString().split("|");
          var figure = document.createElement('figure');
          figure.addEventListener("click", show_detail);
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

// 페이지를 로드할때마다 업로드 했었던 정보 가지고와서 메인페이지에 정렬
$(function(){
    readTextFile("alcohol_recipenames.txt");
});

// 업로드 폼 창의 close 버튼 클릭시 입력되었던값 모두 초기화 후 안보이게함 
$("#close_modal").click(function () {
  document.getElementById('recipename').value="";
  document.getElementById("recipe_textarea").value="";
  document.getElementById("selected_img").value="";
  document.getElementById("Recipe").style.display="none";
});
