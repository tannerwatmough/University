<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Update Customer</title>
    <link rel="stylesheet" href="../main.css" type="text/css" />
</head>
<body>
</body>
</html>
<?php 
    // All specific error messages for form validation
    $fname_err = '';
    $lname_err = '';
    $addr_err = '';
    $city_err = '';
    $state_err = '';
    $postal_err = '';
    $phone_err = '';
    $email_err = '';
    $pass_err = '';

    require_once('../database/database.php');
    // get data from form
    $first_name = filter_input(INPUT_POST, 'fName');
    $last_name = filter_input(INPUT_POST, 'lName');
    $address = filter_input(INPUT_POST, 'addr');
    $city = filter_input(INPUT_POST, 'city');
    $state = filter_input(INPUT_POST, 'state');
    $postal = filter_input(INPUT_POST, 'postal');
    $country = filter_input(INPUT_POST, 'country');
    $email = filter_input(INPUT_POST, 'email');
    $phone = filter_input(INPUT_POST, 'phone');
    $pass = filter_input(INPUT_POST, 'pass');
    $customer_id = filter_input(INPUT_POST, 'customer_id');

    // If customer_id null, search for email associated with it. If nothing
    // returned, then user isn't in database, else, should be update procedure.
    if($customer_id == null) {
        $query = 'SELECT customerID
                FROM customers
                WHERE email = :email';
        $statement = $db->prepare($query);
        $statement->bindValue(':email', $email);
        try {
            $statement->execute();
        } catch (PDOException $e) {
            $error_message = $e->getMessage();
            include('update_customer.php');
            exit();
        }
        $customer_id = $statement->fetchAll();
        $statement->closeCursor();
    }

    $err_flag = false;

    $n = count(preg_grep('~^[0-9]$~', str_split($phone)));

    // Format names
    $first_name = ucwords(strtolower(trim($first_name)));
    $last_name = ucwords(strtolower(trim($last_name)));
    $phone = trim($phone);
    $phone = str_replace('.', '', $phone);
    $phone = str_replace('-', '', $phone);
    $phone = str_replace('(', '', $phone);
    $phone = str_replace(')', '', $phone);
    $phone = str_replace(' ', '', $phone);
    $phone = str_replace('+', '', $phone);
    $phone = substr($phone, 0, 3)."-".substr($phone, 3, 3)."-".substr($phone, 6);

    // validate form data
    if ($first_name == null) {
        $fname_err = 'First name cannot be blank.';
        $err_flag = true;
    } else if (strlen($first_name) >= 51) {
        $fname_err = 'First name cannot be greater than 50 characters.';
        $err_flag = true;
    } 
    
    if ($last_name == null) {
        $lname_err = 'Last name cannot be blank.';
        $err_flag = true;
    } else if (strlen($last_name) >= 51) {
        $lname_err = 'Last name cannot be greater than 50 characters.';
        $err_flag = true;
    }

    if ($address == null) {
        $addr_err = 'Address cannot be blank.';
        $err_flag = true;
    } else if (strlen($address) >= 51) {
        $addr_err = 'Address cannot be greater than 50 characters.';
        $err_flag = true;
    }

    if ($city == null) {
        $city_err = 'City cannot be blank.';
        $err_flag = true;
    } else if (strlen($city) >= 51) {
        $city_err = 'City cannot be greater than 50 characters.';
        $err_flag = true;
    } 

    if ($state == null) {
        $state_err = 'State cannot be blank.';
        $err_flag = true;
    } else if (strlen($state) >= 51) {
        $state_err = 'State cannot be greater than 50 characters.';
        $err_flag = true;
    } 

    if ($postal == null) {
        $postal_err = 'Postal code cannot be blank.';
        $err_flag = true;
    } else if (strlen($postal) >= 21) {
        $postal_err = 'Postal code cannot be greater than 20 characters.';
        $err_flag = true;
    }

    if ($email == null) {
        $email_err = 'Email cannot be blank.';
        $err_flag = true;
    } else if (strlen($email) >= 51) {
        $email_err = 'Email cannot be greater than 50 characters.';
        $err_flag = true;
    }

    if ($phone == null) {
        $phone_err = 'Phone number cannot be blank.';
        $err_flag = true;
    } else if ($n > 10) {
        $phone_err = 'Phone number cannot be more than 10 numbers.';
        $err_flag = true;
    } else if ($n < 10) {
        $phone_err = 'Phone number cannot be less than 10 numbers.';
        $err_flag = true;
    } 

    if ($pass == null) {
        $pass_err = 'Password cannot be blank';
        $err_flag = true;
    } else if (strlen($pass) >= 21) {
        $pass_err = 'Password cannot be greater than 20 characters.';
        $err_flag = true;
    } else if (strlen($pass) < 6) {
        $pass_err = 'Password cannot be less than 6 characters.';
        $err_flag = true;
    } 

    // Get if update or add action
    $action = filter_input(INPUT_POST, 'action');

    // Display error message if any
    if (!empty($error_message) || $err_flag) {
        switch($action) {
            case 'add':
                include('add_customer.php');
                exit();
            case 'update':
                include('update_customer.php');
                exit();
        }
    // Otherwise, execute add product to database
    } else {
        $error_message = '';

        // Gets country codes to country names for database storage.
        $query = 'SELECT countryCode
                  FROM countries
                  WHERE countryName = :country';
        $statement = $db->prepare($query);
        $statement->bindValue(':country', $country);
        try {
            $statement->execute();
        } catch (PDOException $e) {
            $error_message = $e->getMessage();
            include('update_customer.php');
            exit();
        }
        $country_code = $statement->fetchAll();
        $country_code = $country_code[0][0];
        $statement->closeCursor();

        // If action is add, search database for email from customerID. 
        // If match, should be update procedure.
        if (strcmp($action, 'add') == 0) {
            $query = 'SELECT email
                      FROM customers
                      WHERE customerID = :cust_id';
            $statement = $db->prepare($query);
            $statement->bindValue(':cust_id', $customer_id[0][0]);
            // Try to execute database statement, catch exceptions.
            try {
                $statement->execute();
            } catch (PDOException $e) {
                $error_message = $e->getMessage();
                include('add_customer.php');
                exit();
            }
            $customer_array = $statement->fetchAll();
            $statement->closeCursor();
        }

        // If add and query found an entry, switch to update.
        if (!empty($customer_array)) {
            $action = 'update';
        }   

        // Switch statement to process both add and update commands in same php
        switch($action) {
            case 'add':
                // Add customer to database
                $query = 'INSERT INTO customers
                            (firstName, lastName, address, city, state, 
                            postalCode, countryCode, phone, email, password)
                        VALUES
                            (:f_name, :l_name, :addr, :city, :state, :postal, 
                            :country_code, :phone, :email, :pass)';
                $statement = $db->prepare($query);
                $statement->bindValue(':f_name', $first_name);
                $statement->bindValue(':l_name', $last_name);
                $statement->bindValue(':addr', $address);
                $statement->bindValue(':city', $city);
                $statement->bindValue(':state', $state);
                $statement->bindValue(':postal', $postal);
                $statement->bindValue(':country_code', $country_code);
                $statement->bindValue(':phone', $phone);
                $statement->bindValue(':email', $email);
                $statement->bindValue(':pass', $pass);
                // Try to execute database statement, catch exceptions.
                try {
                    $statement->execute();
                } catch (PDOException $e) {
                    $error_message = $e->getMessage();
                    include('add_customer.php');
                    exit();
                }
                $statement->closeCursor();
                break;
            case 'update':                
                // Update customer in database
                $query = 'UPDATE customers
                        SET 
                            firstName = :f_name,
                            lastName = :l_name,
                            address = :addr,
                            city = :city,
                            state = :state,
                            postalCode = :postal,
                            countryCode = :country_code,
                            phone = :phone,
                            email = :email,
                            password = :pass
                        WHERE customerID = :cust_id';
                $statement = $db->prepare($query);
                $statement->bindValue(':f_name', $first_name);
                $statement->bindValue(':l_name', $last_name);
                $statement->bindValue(':addr', $address);
                $statement->bindValue(':city', $city);
                $statement->bindValue(':state', $state);
                $statement->bindValue(':postal', $postal);
                $statement->bindValue(':country_code', $country_code);
                $statement->bindValue(':phone', $phone);
                $statement->bindValue(':email', $email);
                $statement->bindValue(':pass', $pass);
                $statement->bindValue(':cust_id', $customer_id[0][0]);
                // Try to execute database statement, catch exceptions.
                try {
                    $statement->execute();
                } catch (PDOException $e) {
                    $error_message = $e->getMessage()." update";
                    include('update_customer.php');
                    exit();
                }
                $statement->closeCursor();
                break;
        }
        
        // Go back to add customer in both cases due to binding issues. 
        switch ($action) {
            case 'add':
                include('add_customer.php');
                exit();
            case 'update':
                include('add_customer.php');
                exit();
        }


    }
?>