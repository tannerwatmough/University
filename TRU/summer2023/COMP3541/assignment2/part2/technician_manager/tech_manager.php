<?php 
    require_once('../database/database.php');

    // Get all technicians
    $queryTechnicians = 'SELECT * FROM technicians ORDER BY techID';
    $statement = $db->prepare($queryTechnicians);
    $statement->execute();
    $technicians = $statement->fetchAll();
    $statement->closeCursor();
?>
<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Technician Manager</title>
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
        <h2>Technician List</h2>

        <section>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Password</th>
                    <th>&nbsp;</th>
                </tr>
                <!-- Display Technicians in table -->
                <?php foreach ($technicians as $technician) : ?>
                <tr>
                    <td><?php echo htmlspecialchars($technician['firstName']); ?></td>
                    <td><?php echo htmlspecialchars($technician['lastName']); ?></td>
                    <td><?php echo htmlspecialchars($technician['email']); ?></td>
                    <td><?php echo htmlspecialchars($technician['phone']); ?></td>
                    <td><?php echo htmlspecialchars($technician['password']); ?></td>
                    <!-- Delete technicians buttons -->
                    <td><form action="delete_technician.php" method="post">
                        <input type="hidden" name="technician_id" 
                            value="<?php echo $technician['techID']; ?>" />
                        <input type="submit" value="Delete" />
                    </form></td>
                </tr>
                <?php endforeach; ?>
            </table>
            <!-- Add Technician button -->
            <p><a href="add_technician_form.php">Add Technician</a></p>
        </section>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>