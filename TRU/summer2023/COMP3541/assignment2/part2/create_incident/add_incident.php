<?php 
    require_once('../database/database.php');

    // Get product data.
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


    // get data from form
    $product_sel = filter_input(INPUT_POST, 'product_sel');
    $title = filter_input(INPUT_POST, 'title');
    $description = filter_input(INPUT_POST, 'desc');
    $customer_id = filter_input(INPUT_POST, 'cust_info');


    // Get product code of selected product
    foreach ($products as $product) {
        if (strcmp($product['name'], "$product_sel") == 0) {
            $product_code = $product['productCode'];
        }
    }

    // Display error message if any
    if (!empty($error_message)) {
        include('create_incident.php');
        exit();
    // Otherwise, execute add product to database
    } else {
        // Add incident to database
        $query = 'INSERT INTO incidents
                    (customerID, productCode, dateOpened, title, description)
                VALUES
                    (:customer_id, :prod_code, now(), :title, :desc)';
        $statement = $db->prepare($query);
        $statement->bindValue(':customer_id', $customer_id);
        $statement->bindValue(':prod_code', $product_code);
        $statement->bindValue(':title', $title);
        $statement->bindValue(':desc', $description);
        // Try to execute database statement, catch exceptions.
        try {
            $statement->execute();
        } catch (PDOException $e) {
            $error_message = $e->getMessage();
            include('create_incident.php');
            exit();
        }
        $statement->closeCursor();

    }
?>
<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Incident Creation</title>
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
        <p>Incident was added to our database.</p>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>