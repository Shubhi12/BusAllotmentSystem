<?php
session_start();
include("db.php");
$email=$_POST['email'];
$query="select * from usar_details where email='".$email."'";
$result=mysql_query($query);
while($row=mysql_fetch_assoc($result))
{
$output[]=$row;
}
print(json_encode($output));
mysql_close();
?>