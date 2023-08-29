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
        <h2>Get Customer</h2>
        <form action="create_incident.php" method="post">
            <label>Email:</label>
            <input type="email" name="email" />
            <input type="submit" value="Get Customer" /><br />
        </form>

        <?php 
                // Display error message if any
                if (!empty($error_message)) {
                    echo '<p class="error">';
                    echo htmlspecialchars($error_message);
                    echo '</p>';
                } 
        ?>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>