<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Add Product</title>
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
        <h2>Add Product</h2>

        <form action="" method="post" id="aligned">
            <label>Code:</label>
            <input type="text" name="code" /><br />

            <label>Name:</label>
            <input type="text" name="name" /><br />

            <label>Version:</label>
            <input type="text" name="ver" /><br />

            <label>Release Date:</label>
            <input type="text" name="date" />
            <span>&nbsp;Use any valid date format</span><br />

            <label>&nbsp;</label>
            <input type="submit" value="Add Product" /><br />
        </form>
        <?php 
            if($_SERVER['REQUEST_METHOD'] === 'POST') {
                // Form submitted
                $exception = false;

                // get data from form
                $product_code = filter_input(INPUT_POST, 'code');
                $name = filter_input(INPUT_POST, 'name');
                $version = filter_input(INPUT_POST, 'ver', FILTER_VALIDATE_FLOAT);
                $rel_date = filter_input(INPUT_POST, 'date');

                // validate fields
                if ($product_code == null) {
                    $error_message = 'Product code cannot be empty.';
                } else if ($name == null) {
                    $error_message = 'Name cannot be empty.';
                } else if ($version == null) {
                    $error_message = 
                        'Version cannot be empty and must be a decimal number.';
                } else if ($version <= 0) {
                    $error_message = 'Version must be a positive decimal value';
                } else if ($rel_date == null) {
                    $error_message = 'Release date cannot be empty.';
                } else {
                    $error_message = '';
                }

                $product_code = strtoupper($product_code);
    
                // Format string date to proper date
                $rel_date = date("Y-m-d", strtotime($rel_date));


                // Display error message if any
                if (!empty($error_message)) {
                    echo '<p class="error">';
                    echo htmlspecialchars($error_message);
                    echo '</p>';
                // Otherwise, execute add product to database
                } else {
                    require_once('../database/database.php');

                    // Add product to database
                    $query = 'INSERT INTO products
                                (productCode, name, version, releaseDate)
                              VALUES
                                (:product_code, :name, :version, :release_date)';
                    $statement = $db->prepare($query);
                    $statement->bindValue(':product_code', $product_code);
                    $statement->bindValue(':name', $name);
                    $statement->bindValue(':version', $version);
                    $statement->bindValue(':release_date', $rel_date);
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

                    // Display the Product List page if no exceptions occurred 
                    // on database execution
                    if (!$exception) {
                        header("Location: product_manager.php");
                        exit();
                    }
                }
            }
        ?>
        <!-- Return to product list -->
        <p><a href="product_manager.php">View Product List</a></p>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>