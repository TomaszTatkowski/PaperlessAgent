<?php 
require "conn.php";

$address=$_POST["address"];
$ownership=$_POST["ownership"];
$sellOrRent=$_POST["sellOrRent"];
$propertyType=$_POST["propertyType"];
$eICR=$_POST["eICR"];
$ePC=$_POST["ePC"];
$gC=$_POST["gC"];
$pAT=$_POST["pAT"];
$cooker=$_POST["cooker"];
$fridge=$_POST["fridge"];
$washer=$_POST["washer"];
$renovationRequired=$_POST["renovationRequired"];
$availability=$_POST["availability"];
$price=$_POST["price"];
$billsIncluded=$_POST["billsIncluded"];
$noOfRooms=$_POST["noOfRooms"];
$furnished=$_POST["furnished"];
$noOfBathrooms=$_POST["noOfBathrooms"];
$noOfToilets=$_POST["noOfToilets"];
$toiletsInBathrooms=$_POST["toiletsInBathrooms"];
$garden=$_POST["garden"];
$driveway=$_POST["driveway"];
$carpark=$_POST["carpark"];
$comments=$_POST["comments"];
$directoryPath=$_POST["directoryPath"];

$mysql_qry = "insert into properties (Address, Ownership, SellOrRent, PropertyType, EICR, EPC, GC, PAT, Cooker, Fridge, Washer, RenovationRequired, Availability, Price, BillsIncluded, NoOfRooms, Furnished, NoOfBathrooms, NoOfToilets, ToiletsInBathrooms, Garden, Driveway, Carpark, Comments, DirectoryPath) values ('$address', '$ownership', '$sellOrRent', '$propertyType', '$eICR', '$ePC', '$gC', '$pAT', '$cooker', '$fridge', '$washer', '$renovationRequired', '$availability', '$price', '$billsIncluded', '$noOfRooms', '$furnished', '$noOfBathrooms', '$noOfToilets', '$toiletsInBathrooms', '$garden', '$driveway', '$carpark', '$comments', '$directoryPath')";


if($conn->query($mysql_qry)===TRUE) {
echo "Data send to the server.";
}
else {
echo "Error: " .$sql . "<br>" . $conn->error;
}
$conn->close();
 
?>