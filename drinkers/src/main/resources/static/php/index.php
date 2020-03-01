<?php
// 로그인 실행시 넘어오는 php파일

$myfile = fopen("../data/person.txt", "r") or die("can't open file");

$Id = $_GET["id"];
$Password = $_GET["pass"];
$num=0;

while( !feof($myfile) ) {
    $my_id = fgets($myfile);
    $my_pass = fgets($myfile);
    if($Id==trim($my_id)){
        $num++;
        if($Password==trim($my_pass)){
            $num++;
            break;
        }
        else{
            echo "패스워드가 틀립니다";
            break;
        }
    }
}
if($num==0){
    echo "존재하지않는 아이디 입니다";
}
fclose($myfile);
?>
