<?php
require_once('../database/database.php');

// Get IDs
$tech_id = filter_input(INPUT_POST, 'technician_id');

// Delete the technician from the database
if ($tech_id != false) {
    $query = 'DELETE FROM technicians
              WHERE techID = :tech_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':tech_id', $tech_id);
    $success = $statement->execute();
    $statement->closeCursor();    
}

// Display the technician List page
include('tech_manager.php');