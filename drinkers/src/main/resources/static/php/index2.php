<?php
// 회원가입시 아이디 중복 조회

$myfile2 = fopen("../data/person.txt", "r") or die("can't open file");

$Id=$_GET['text1'];
$num=0;

while( !feof($myfile2) ) {
    $my_id = fgets($myfile2);
    $my_pass = fgets($myfile2);
    
    if($Id==trim($my_id)){
        echo "이미 사용중인 아이디입니다.";
        $num++;
        break;
    }
}
if($num==0){
    echo "사용 가능한 아이디 입니다.";
}

fclose($myfile2);

?>
