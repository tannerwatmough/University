<?php 
    //set default value of variables for initial page load
    if (!isset($name)) { $name = ''; } 
    if (!isset($email)) { $email = ''; } 
    if (!isset($phone)) { $phone = ''; } 
?> 
<!DOCTYPE html>
<html>
<head>
    <title>String Tester</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>

<body>
    <main>
    <h1>String Tester</h1>
    <form action="" method="post">

        <div id="data">
            <label>Name:</label>
            <input type="text" name="name" 
                value="<?php echo htmlspecialchars($name); ?>" required>
            <br>

            <label>E-Mail:</label>
            <input type="email" name="email"
                value="<?php echo htmlspecialchars($email); ?>" required>
            <br>

            <!-- Makes sure the phone number matches the specified pattern -->
            <label>Phone Number:</label>
            <input type="tel" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                value="<?php echo htmlspecialchars($phone); ?>" required>
            <br>
            <label>&nbsp;</label>
            <span><small>Format: 123-456-7890</small></span>
            <br>
        </div>

        <div id="buttons">
            <label>&nbsp;</label>
            <input type="submit" value="Submit"><br>
        </div>

    </form>

    <?php 
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Form submitted

            // get the data from the form
            $name = filter_input(INPUT_POST, 'name');
            $email = filter_input(INPUT_POST, 'email');
            $phone = filter_input(INPUT_POST, 'phone');

            // validate name
            if ($name === FALSE ) {
                $error_message = 'Name cannot be blank.';          
            // validate email
            } else if ( $email === FALSE )  {
                $error_message = 'E-mail cannot be blank.'; 
            // validate phone
            } else if ( $phone === FALSE ) {
                $error_message = 'Phone number cannot be blank.';
            // set error message to empty string if no invalid entries
            } else {
                $error_message = ''; 
            }
            
            if (!empty($error_message)) {
                echo '<p class="error">';
                echo htmlspecialchars($error_message);
                echo '</p>';
            // Only will do the message and display if no error messages.
            } else {
                // formats names
                $name = strtolower($name);
                $name = ucwords(trim($name));

                // prevents uninitialized variables. 
                $first_name = '';
                $middle_name = '';
                $last_name = '';

                // checks to see if a first, middle, and last name were entered.
                $pos1 = strpos($name, ' ');
                $pos2 = strrpos($name, ' ',);
                if ($pos1 === false) {
                    $first_name = $name;
                } else {
                    $first_name = substr($name, 0, $pos1);
                    if ($pos2 === false) {
                        $last_name = substr($name, $pos1 + 1);
                    } else {
                        $middle_name = substr($name, $pos1 + 1, $pos2 - $pos1);
                        $last_name = substr($name, $pos2 + 1);
                    }
                }

                // sanitizing phone number input
                $phone_f = str_replace('.', '', $phone);
                $phone_f = str_replace('-', '', $phone_f);
                $phone_f = str_replace('(', '', $phone_f);
                $phone_f = str_replace(')', '', $phone_f);
                $phone_f = str_replace(' ', '', $phone_f);
                $phone_f = str_replace('+', '', $phone_f);
                // divvy up phone number
                $area_code = "(".substr($phone_f, 0, 3).")";
                $area_suffix = substr($phone_f, 3, 3)."-".substr($phone_f, 6);

                // Displays message
                echo '<h2>Message:</h2>';
                echo "<p>Hello $first_name,<br><br>";
                echo 'Thank you for entering this data:<br><br>';
                echo "Name: $first_name $middle_name $last_name <br>";
                echo "Email: $email <br>";
                echo "Phone: $phone <br><br>";
                echo "First Name: $first_name <br>";
                echo "Middle Name: $middle_name <br>";
                echo "Last Name: $last_name <br><br>";
                echo "Area code: $area_code <br>";
                echo "Phone number: $area_suffix </p>";

            }
        }
    ?>
        
    </main>
</body>
</html>