<?php

$DB_USERNAME = "id1777825_kishoreganth700";
$DB_PASSWORD = "Kishore@98";
$DB_HOST = "localhost";
$DB_NAME = "id1777825_studentbuddy";

$con = mysqli_connect($DB_HOST,$DB_USERNAME,$DB_PASSWORD,$DB_NAME);


    // array for json response
    $response = array();
    $response["News"] = array();
$sql = "SELECT * FROM NewsFeed";
$result = mysqli_query($con,$sql);

while($row = mysqli_fetch_array($result)){
$tmp = array();
$tmp["Nid"]=$row["Nid"];
$tmp["NewsTitle"]=$row["NewsTitle"];
$tmp["NewsDesc"]=$row["NewsDesc"];
$tmp["NewsImageURL"]=$row["NewsImageURL"];


array_push($response["News"],$tmp);
}

header('Content-Type: application/json');
echo json_encode($response);



?>