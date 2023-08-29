<?php 
    // Ensures that email is taken from login.php if error, instead of from
    // $_POST
    if(isset($error_message) && str_contains($error_message, 'already')) {

    } else {
        $email = filter_input(INPUT_POST, 'email');
    }
    

    // validate fields
    if ($email == null) {
        $error_message = 'Email cannot be empty.';
        include('login.php');
        exit();    
    }


    // Go back to login if email null
    if (isset($error_message) && str_contains($error_message, 'Email')) {
        include('login.php');
        exit();
    } // Otherwise, search database
    else {
        require_once('../database/database.php');

        // Search customer names
        $query = 'SELECT customerID, firstName, lastName
                    FROM customers
                    WHERE email = :email';
        $statement = $db->prepare($query);
        $statement->bindValue(':email', $email);
        // Try to execute database statement, catch exceptions.
        try {
            $statement->execute();
        } catch (PDOException $e) {
            $error_message = $e->getMessage();
            include('login.php');
            exit();            
        }
        $customer_info = $statement->fetchAll();
        $statement->closeCursor();

        if($customer_info == null) {
            $error_message = 'Email not in system';
            include('login.php');
            exit();    
        }
                    
        // Display the Customer List page
        
        // Get registration data.
        $query = 'SELECT *
                    FROM products';
        $statement = $db->prepare($query);
        // Try to execute database statement, catch exceptions.
        try {
            $statement->execute();
        } catch (PDOException $e) {
            $error_message = $e->getMessage();
            include('login.php');
            exit();
        }
        $products = $statement->fetchAll();
        $statement->closeCursor();
    }
        ?>
<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Product Registration</title>
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
        <h2>Register Product</h2>
        <!-- If any errors, display -->
        <?php if (!empty($error_message)) { ?>
            <p class="error"><?php echo htmlspecialchars($error_message); ?></p>
        <?php } ?>
        <form action="register.php" method="post" id="aligned">
            <label>Customer:</label>
            <label>
                <!-- Gets first and last name -->
                <?php 
                    echo $customer_info[0][1]." ";
                    echo $customer_info[0][2];
                ?>
            </label><br />

            <label>Product:</label>
            <select name="product">
            <?php
            // Display Products in drop down.
            foreach ($products as $product) : ?>           
                <option>
                <?php
                    echo htmlspecialchars($product['name']); ?>
                </option>
            <?php endforeach; ?>
            </select><br />
            <label>&nbsp;</label> 
            <!-- Inputs used to pass on customer_id and email to login.php -->
            <input type="hidden" name="customer_id" 
                value="<?php echo htmlspecialchars($customer_info[0][0]); ?>" />
            <input type="hidden" name="err_email" 
                value="<?php echo htmlspecialchars($email); ?>" />
            <input type="submit" value="Register Product" /><br />
        </form>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>