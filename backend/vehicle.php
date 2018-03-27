<?php
session_start();
include("db.php");
$query="select * from vehicle";
$result=mysql_query($query);
while($row=mysql_fetch_assoc($result))
{
$output[]=$row;
}
print(json_encode($output));
mysql_close();
?>