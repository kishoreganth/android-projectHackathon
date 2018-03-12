<?php

$DB_USERNAME = "id1777825_kishoreganth700";
$DB_PASSWORD = "Kishore@98";
$DB_HOST = "localhost";
$DB_NAME = "id1777825_studentbuddy";

$con = mysqli_connect($DB_HOST,$DB_USERNAME,$DB_PASSWORD,$DB_NAME);


    // array for json response
    $response = array();
    $response["Dept"] = array();
$sql = "SELECT * FROM DeptList";
$result = mysqli_query($con,$sql);

while($row = mysqli_fetch_array($result)){
$tmp = array();
$tmp["Did"]=$row["Did"];
$tmp["Dept"]=$row["Dept"];


array_push($response["Dept"],$tmp);
}

header('Content-Type: application/json');
echo json_encode($response);



?>