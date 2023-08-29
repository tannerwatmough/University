<?php 
    require_once('../database/database.php');

    // Get registration data.
    $query = 'SELECT productCode, name
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

    // get the data from the form
    $product_sel = filter_input(INPUT_POST, 'product');
    $customer_id = filter_input(INPUT_POST, 'customer_id');
    $email = filter_input(INPUT_POST, 'err_email');

    // Get product code of selected product
    foreach ($products as $product) {
        if (strcmp($product['name'], "$product_sel") == 0) {
            $product_code = $product['productCode'];
        }
    }
    // Add selection to customer's registrations
    $query = 'INSERT INTO registrations
                (customerID, productCode, registrationDate)
            VALUES
                (:custID, :prodCode, now())';
    $statement = $db->prepare($query);
    $statement->bindValue(':custID', $customer_id);
    $statement->bindValue(':prodCode', $product_code);

    // Try to execute database statement, catch exceptions.
    try {
        $statement->execute();
    } catch (PDOException $e) {
        $error_message = $e->getMessage();
        if (str_contains($error_message, 'Duplicate entry')) {
            $error_message = "Product already registered with customer.";
        }
        $email; 
        include('product_register.php');
        exit();
    }
    $statement->closeCursor();
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
        <p>Product (<?php echo htmlspecialchars($product_code)?>) was registered 
        successfully.</p>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>