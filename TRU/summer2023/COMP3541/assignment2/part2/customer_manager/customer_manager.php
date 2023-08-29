<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Customer Manager</title>
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
        <h2>Customer Search</h2>
        <form action="" method="post">
            <label>Last Name:</label>
            <input type="text" name="last_name" />
            <input type="submit" value="Search" /><br />
        </form>
        <?php 
           
        ?>
        <?php 
            if($_SERVER['REQUEST_METHOD'] === 'POST') {
                // Form submitted
                $exception = false;

                // get data from form
                $last_name = filter_input(INPUT_POST, 'last_name');

                // validate fields
                if ($last_name == null) {
                    $error_message = 'Last name cannot be empty.';
                } else {
                    $error_message = '';
                }


                // Display error message if any
                if (!empty($error_message)) {
                    echo '<p class="error" id="err">';
                    echo htmlspecialchars($error_message);
                    echo '</p>';
                // Otherwise, search database
                } else {
                    require_once('../database/database.php');

                    // Search customer names
                    $query = 'SELECT *
                              FROM customers
                              WHERE lastName LIKE :l_name
                              ORDER BY firstName';
                    $statement = $db->prepare($query);
                    $statement->bindValue(':l_name', $last_name);
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
                    $customers = $statement->fetchAll();
                    $statement->closeCursor();
                    
                    // Display the Customer List page if no exceptions occurred 
                    // on database execution
                    if (!$exception) {
                        echo '<h2>Results</h2>';
                        echo '<section>';
                        echo '<table><tr>';
                        echo '<th>Name</th>';
                        echo '<th>Email Address</th>';
                        echo '<th>City</th>';
                        echo '<th>&nbsp;</th></tr>';
                        // Display Customers in table
                        foreach ($customers as $customer) :
                            echo '<tr><td>';
                            echo htmlspecialchars($customer['firstName'])." ";
                            echo htmlspecialchars($customer['lastName']);
                            echo '</td><td>';
                            echo htmlspecialchars($customer['email']);
                            echo '</td><td>';
                            echo htmlspecialchars($customer['city']).'</td><td>';
                            echo '<form action="update_customer.php" method="post">';
                            echo '<input type="hidden" name="customer_id" value="';
                            echo $customer['customerID'].'" />';
                            echo '<input type="submit" value="Select" />';
                            echo '</form></td></tr>';
                        endforeach;

                        echo '</table>';
                    }
                }
            }
        ?>

        <!-- Add Customer button -->
        <h2>Add a new customer</h2>
        <form action="add_customer.php" method="post">
            <input type="submit" value="Add Customer" />
        </form>
        </section>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>