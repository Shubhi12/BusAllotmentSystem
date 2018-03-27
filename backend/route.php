<?php
session_start();
include("db.php");
$source=$_POST['source'];
$destination=$_POST['destination'];
$date=$_POST['date'];
$arr=explode("/",$date);
$dstr=$arr[2]."-".$arr[1]."-".$arr[0];

$day= date('D', strtotime($dstr));
//$sql="insert into route(date) value('".$_POST['seat']."')";
$query="select * from route where designation='".$destination."' and source='".$source."'";
$result=mysql_query($query);
while($row=mysql_fetch_assoc($result))
{
	$day=$row['day'];
	$arr=explode(",",$day);
    $dstr=$arr[2].",".$arr[1].",".$arr[0];

$bus=$row['bus_no'];
$query1="select * from vehicle where number='".$bus."'";
$result1=mysql_query($query1);
$row1=mysql_fetch_assoc($result1);
$row['categary']=$row1['categary'];
$row['seats']=$row1['seats'];	
$tid=$row1['travel_id'];

$query2="select * from travel where id=".$tid."";
$result2=mysql_query($query2);
$row2=mysql_fetch_assoc($result2);
$row['agency']=$row2['name'];

$output[]=$row;
}
print(json_encode($output));
mysql_close();
?>