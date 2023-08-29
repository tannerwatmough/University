<?php
    if (!isset($fname_err)) { $fname_err = ''; } 
    if (!isset($lname_err)) { $lname_err = ''; } 
    if (!isset($addr_err)) { $addr_err = ''; } 
    if (!isset($city_err)) { $city_err = ''; } 
    if (!isset($state_err)) { $state_err = ''; } 
    if (!isset($postal_err)) { $postal_err = ''; } 
    if (!isset($phone_err)) { $phone_err = ''; } 
    if (!isset($email_err)) { $email_err = ''; } 
    if (!isset($pass_err)) { $pass_err = ''; } 

    require_once('../database/database.php');
    
    // Get country names
    $query = "SELECT countryName FROM countries";
    $statement = $db->prepare($query);
    $success = $statement->execute();
    $countries = $statement->fetchAll();
    $statement->closeCursor();   
?>

<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Add Customer</title>
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
        <h2>Add/Update Customer</h2>

        <form action="process_customer.php" method="post" id="aligned">
            <label>First Name:</label>
            <input type="text" name="fName" />
            &nbsp;
            <?php if (!empty($fname_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($fname_err);
                echo '</span>';
            }
            ?><br />

            <label>Last Name:</label>
            <input type="text" name="lName" />
            &nbsp;
            <?php if (!empty($lname_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($lname_err);
                echo '</span>';
            }
            ?><br />

            <label>Address:</label>
            <input type="text" name="addr" />
            &nbsp;
            <?php if (!empty($addr_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($addr_err);
                echo '</span>';
            }
            ?><br />

            <label>City:</label>
            <input type="text" name="city" />
            &nbsp;
            <?php if (!empty($city_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($city_err);
                echo '</span>';
            }
            ?><br />

            <label>State:</label>
            <input type="text" name="state" />
            &nbsp;
            <?php if (!empty($state_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($state_err);
                echo '</span>';
            }
            ?><br />

            <label>Postal Code:</label>
            <input type="text" name="postal" />
            &nbsp;
            <?php if (!empty($postal_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($postal_err);
                echo '</span>';
            }
            ?><br />

            <label>Country:</label>
            <select name="country">
                <!-- Selects Canada for new customers as default -->
                <?php foreach ($countries as $country) : ?>
                <option <?php if (strcmp($country['countryName'], "Canada") == 0) {
                    echo 'selected="selected"'; } ?> >
                    <?php 
                        echo htmlspecialchars($country['countryName']); ?>
                </option>
                <?php endforeach; ?>
            </select></br>

            <label>Phone:</label>
            <input type="tel" name="phone" />
            &nbsp;
            <?php if (!empty($phone_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($phone_err);
                echo '</span>';
            }
            ?><br />

            <label>Email:</label>
            <input type="email" name="email" />
            &nbsp;
            <?php if (!empty($email_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($email_err);
                echo '</span>';
            }
            ?><br />

            <!-- I would normally put type to password, but example doesn't
                 show **** -->
            <label>Password:</label>
            <input type="text" name="pass" />
            &nbsp;
            <?php if (!empty($pass_err)){ 
                echo '<span class="error">';
                echo htmlspecialchars($pass_err);
                echo '</span>';
            }
            ?><br />
            
            <input type="hidden" name="action" value="add" />

            <label>&nbsp;</label>
            <input type="submit" value="Add Customer" /><br />
        </form>
        <?php 
            // Display error message if any
            if (!empty($error_message)) {
                echo '<p class="error">';
                echo htmlspecialchars($error_message);
                echo '</p>';
            }
        ?>
        <!-- Return to customer search -->
        <p><a href="customer_manager.php">Search Customers</a></p>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>