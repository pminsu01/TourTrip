<?php
$DB_host =;  # DB_URL

$DB_User =     ;     # DB user name
$DB_Password=;   # DB password
$DB_name='starthon';           # DB type
$TABLE_name = "start";      # DB Table select

$where =$_POST["where"];



$Connect = mysqli_connect($DB_host , $DB_User , $DB_Password ,$DB_name);
mysqli_set_charset($Connect, "utf8");

$Sql_amount_query = "
select  picture_url
from start
where region = '$where';";  # where 

$Sql_amount = mysqli_query ($Connect,$Sql_amount_query);
$Row_count = mysqli_num_rows($Sql_amount); 

if($Row_count== 0 )
        echo '0';


else {

                 while($Row_count) {
                 $rows=mysqli_fetch_array($Sql_amount);

                 for($i=0; $i<4;$i++){
                 echo "$rows[$i]";
                
                 }
                 if($Row_count !=1) print("@");



                 $Row_count--;
                 }

}
?>
