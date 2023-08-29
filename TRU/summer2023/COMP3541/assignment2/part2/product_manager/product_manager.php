<?php 
    require_once('../database/database.php');

    // Get all products
    $queryProducts = 'SELECT * FROM products ORDER BY productCode';
    $statement = $db->prepare($queryProducts);
    $statement->execute();
    $products = $statement->fetchAll();
    $statement->closeCursor();
?>
<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Product Manager</title>
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
        <h2>Product List</h2>

        <section>
            <table>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Version</th>
                    <th>Release Date</th>
                    <th>&nbsp;</th>
                </tr>
                <!-- Display Products in table -->
                <?php foreach ($products as $product) : ?>
                <tr>
                    <td><?php echo htmlspecialchars($product['productCode']); ?></td>
                    <td><?php echo htmlspecialchars($product['name']); ?></td>
                    <td><?php echo htmlspecialchars($product['version']); ?></td>
                    <td>
                        <?php echo htmlspecialchars(date('n-j-Y', strtotime($product['releaseDate']))); ?>
                    </td>
                    <!-- Delete product buttons -->
                    <td><form action="delete_product.php" method="post">
                        <input type="hidden" name="product_code" 
                            value="<?php echo htmlspecialchars($product['productCode']); ?>" />
                        <input type="submit" value="Delete" />
                    </form></td>
                </tr>
                <?php endforeach; ?>
            </table>
            <!-- Add Product button -->
            <p><a href="add_product_form.php">Add Product</a></p>
        </section>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>