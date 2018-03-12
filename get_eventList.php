<?php

$DB_USERNAME = "id1777825_kishoreganth98";
$DB_PASSWORD = "Kishore@98";
$DB_HOST = "localhost";
$DB_NAME = "id1777825_apartment";

$con = mysqli_connect($DB_HOST,$DB_USERNAME,$DB_PASSWORD,$DB_NAME);

$response = array();
$response["Events"] = array();
$sql = "SELECT * FROM eventList";
$result = mysqli_query($con,$sql);

while($row = mysqli_fetch_array($result)){

$tmp = array();
$tmp["Name"]=$row["Name"];
$tmp["Time"]=$row["Time"];
$tmp["Location"]=$row["Location"];
$tmp["Members"]=$row["Members"];

array_push($response["Events"],$tmp);

}
header('Content-Type: application/json');
echo json_encode($response);

?>