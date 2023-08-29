<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Add Technician</title>
    <link rel="stylesheet" href="../main.css" type="text/css" />
</head>
<body>
    <header>
        <nav>
        
            <h1>SportsPro Technical Support</h1>
            <p>Sports management software for sports enthusiasts</p>
            <ul>
                <li><a href="../index.php">Home</a></li>
            </ul>
    </header>
    <main>
        <h2>Add Technician</h2>

        <form action="" method="post" id="aligned">
            <label>First Name:</label>
            <input type="text" name="fName" /><br />

            <label>Last Name:</label>
            <input type="text" name="lName" /><br />

            <label>Email:</label>
            <input type="email" name="email" /><br />

            <label>Phone:</label>
            <input type="tel" name="phone" /><br />

            <!-- I would normally put type to password, but example doesn't
                 show **** -->
            <label>Password:</label>
            <input type="text" name="pass" /><br />
            
            <label>&nbsp;</label>
            <input type="submit" value="Add Technician" /><br />
        </form>
        <?php 
            if($_SERVER['REQUEST_METHOD'] === 'POST') {
                // Form submitted
                $exception = false;

                // get data from form
                $first_name = filter_input(INPUT_POST, 'fName');
                $last_name = filter_input(INPUT_POST, 'lName');
                $email = filter_input(INPUT_POST, 'email');
                $phone = filter_input(INPUT_POST, 'phone');
                $pass = filter_input(INPUT_POST, 'pass');

                $n = count(preg_grep('~^[0-9]$~', str_split($phone)));
                // validate fields
                if ($first_name == null) {
                    $error_message = 'First name cannot be empty.';
                } else if ($last_name == null) {
                    $error_message = 'Last name cannot be empty.';
                } else if ($email == null) {
                    $error_message = 'Email cannot be empty.';
                } else if ($phone == null) {
                    $error_message = 'Phone cannot be empty.';
                } else if ($n < 10) {
                    $error_message = 'Phone must be at least 10 numbers.';
                } else if ($n > 10) {
                    $error_message =
                        'Phone must be less than 11 numbers. Do not include country codes.';
                } else if ($pass == null) {
                    $error_message = 'Password cannot be empty.';
                } else {
                    $error_message = '';
                }

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


                // Display error message if any
                if (!empty($error_message)) {
                    echo '<p class="error">';
                    echo htmlspecialchars($error_message);
                    echo '</p>';
                // Otherwise, execute add product to database
                } else {
                    require_once('../database/database.php');

                    // Add technician to database
                    $query = 'INSERT INTO technicians
                                (firstName, lastName, email, phone, password)
                              VALUES
                                (:f_name, :l_name, :email, :phone, :pass)';
                    $statement = $db->prepare($query);
                    $statement->bindValue(':f_name', $first_name);
                    $statement->bindValue(':l_name', $last_name);
                    $statement->bindValue(':email', $email);
                    $statement->bindValue(':phone', $phone);
                    $statement->bindValue(':pass', $pass);
                    // Try to execute database statement, catch exceptions.
                    try {
                        $statement->execute();
                    } catch (PDOException $e) {
                            $error_message = $e->getMessage();
                            echo '<p class="error">';
                            echo htmlspecialchars($error_message);
                            echo '</p>';
                            $exception = true;
                    }
                    $statement->closeCursor();

                    // Display the Technician List page if no exceptions occurred 
                    // on database execution
                    if (!$exception) {
                        header("Location: tech_manager.php");
                        exit();
                    }
                }
            }
        ?>
        <!-- Return to technician list -->
        <p><a href="tech_manager.php">View Technician List</a></p>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>