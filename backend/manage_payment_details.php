<?php
session_start();
include("db.php");
//$row1=array();
$id= $_POST['id'];
$name=$_POST['name'];
$email= $_POST['email'];
$con=$_POST['con'];
$zip= $_POST['zip'];
$city=$_POST['city'];
$add= $_POST['add'];
$card=$_POST['card'];
$aname= $_POST['aname'];
$month=$_POST['month'];
$year= $_POST['year'];
$cvv=$_POST['cvv'];

$sql="INSERT INTO manage_payment(usar_id,name,email,contact,zip,city,address,card_no,account_name,month,year,cvv_no) 
value('".$id."','".$name."','".$email."','".$con."','".$zip."','".$city."','".$add."','".$card."','".$aname."','".$month."','".$year."','".$cvv."' )";
	$result=mysql_query($sql);
?>