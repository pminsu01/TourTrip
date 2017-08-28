<?php
$DB_host =;  # DB_URL
$DB_User =;           # DB user name
$DB_Password=;   # DB password
$DB_name='starthon';           # DB type
$TABLE_name = "start";      # DB Table select

/*
 $ip_address =&_server['REMOTE_ADDR']; # 사용자 주소 ip
 if($ip_address == '127.0.0.1') print("옳지 않은 접근입니다."); return 0; #예시$
 $car_number = $_POST['car_number'];  #car_number 아이디로 포스트 방식으로 받는$
 $car_where =$_POST['car_where'];
 $car_picture = $_POST['car_picture'];
 */

$where=$_POST["where"];
$picture_url=$_POST["picture_url"];


$Connect = mysqli_connect($DB_host , $DB_User , $DB_Password ,$DB_name) or
die("mysql server can't connect");

if($Connect) echo'connect ok';
else echo 'not connect';

#$Table_Connect = mysqli_select_db($car_number,$DB_NAME); # Table 연결

$Insert_Sql= "insert into $TABLE_name values('$where','$picture_url')";

print($Insert_Sql);
$Result= mysqli_query($Connect,$Insert_Sql);  # (connect 된 DB, Query문을 담고 $


if($Result) {
        $Connect->close();
   echo "result ok";
}

else
        echo "result no";
?>




