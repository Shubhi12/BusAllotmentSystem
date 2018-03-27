<?php
session_start();
include("db.php");
//$row1=array();
$seat= $_POST['seat'];
$date=$_POST['date'];
$arr=explode("/",$date);
$dstr=$arr[2]."-".$arr[1]."-".$arr[0];

$day= date('D', strtotime($dstr));
echo " $day ";

$sql="INSERT INTO usar_details(remain_seat,email,mobile,name,age,gender,booking_day,route_id,booking_date,order_date) 
value('".$seat."','".$_POST['email']."','".$_POST['mobile']."','".$_POST['name']."','".$_POST['age']."','".$_POST['radiosexgroup']."','".$day."','".$_POST['id']."','".$date."', now())";
	$result=mysql_query($sql);
	
	$query="select * from route where id='".$_POST['id']."' ";
$row=mysql_query($query);	
while($row1=mysql_fetch_assoc($row))
	  $bus_no=$row1['bus_no'];
 		$bquery="select * from  vehicle where number='".$bus_no."' ";
	    $brow=mysql_query($bquery);
	    while($bbrow=mysql_fetch_assoc($brow))
	    $total_seat=$bbrow['seats'];
		$remain_seat=$total_seat - $seat;
		$sql2="UPDATE vehicle set seats='".$remain_seat."' where number='".$bus_no."' ";
	     mysql_query($sql2);
?>