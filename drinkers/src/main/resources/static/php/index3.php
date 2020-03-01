<?php
// 회원가입시 person.txt에 아이디와 패스워드 저장

$myfile = fopen("../data/person.txt", "a") or die("can't open file");

$Id=$_GET['id'];
$Password=$_GET['pass'];
echo $Id;

fwrite($myfile, $Id.chr(13).chr(10));
fwrite($myfile, $Password.chr(13).chr(10));

fclose($myfile);
?>
