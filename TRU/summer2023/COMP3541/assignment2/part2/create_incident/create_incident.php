<?php 
    // Ensures that email is taken from customer_search.php if error, instead of from
    // $_POST
    if(isset($error_message)) {
        include('customer_search.php');
        exit();
    } else {
        $email = filter_input(INPUT_POST, 'email');
    }

    if ($email == null) {
        $error_message = 'Email cannot be empty.';
        include('customer_search.php');
        exit();
    }

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
    }
    $customer_info = $statement->fetchAll();
    $statement->closeCursor();

    if ($customer_info == null) {
        $error_message = 'Email not in system';
    }

    if(isset($error_message) && $error_message != '') {
        include('customer_search.php');
        exit();    
    }


                            
    // Get products data.
    $query = 'SELECT registrations.productCode, products.name 
              FROM registrations
              RIGHT JOIN products
                ON registrations.productCode = products.productCode
              WHERE customerID = :customer_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':customer_id', $customer_info[0][0]);
    // Try to execute database statement, catch exceptions.
    try {
        $statement->execute();
    } catch (PDOException $e) {
        $error_message = $e->getMessage();
        $email;
        include('customer_search.php');
        exit();
    }
    $products = $statement->fetchAll();
    $statement->closeCursor();
?>

<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Incident Creator</title>
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
        <h2>Create Incident</h2>
        <!-- If any errors, display -->
        <form action="add_incident.php" method="post" id="aligned">
            <label>Customer:</label>
            <label>
                <!-- Gets first and last name -->
                <?php 
                    echo $customer_info[0][1]." ";
                    echo $customer_info[0][2];
                ?>
                <input type="hidden" name="cust_info" 
                    value="<?php echo htmlspecialchars($customer_info[0][0]); ?>" />
            </label><br />

            <label>Product:</label>
            <select name="product_sel">
            <?php
            // Display Products in drop down.
            foreach ($products as $product) : ?>
                <option>
                <?php
                    echo htmlspecialchars($product['name']); ?>
                </option>
            <?php endforeach; ?>
            </select><br />

            <label>Title:</label>
            <input type="text" name="title" /><br />

            <label>Description:</label>
            <textarea name="desc" rows="5" cols="40"></textarea><br />

            <label>&nbsp;</label> 
            <input type="hidden" name="email" 
                value="<?php echo htmlspecialchars($email) ?>" />
            <input type="submit" name="submit_btn" value="Create Incident" /><br />
        </form>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>