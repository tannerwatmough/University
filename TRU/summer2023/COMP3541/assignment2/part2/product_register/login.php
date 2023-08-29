<!DOCTYPE html>
<html>
<head>
    <title>SportsPro Technical Support | Customer Login</title>
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
        <h2>Customer Login</h2>
        <!-- Display error message, if any -->
        <?php if (!empty($error_message)) { ?>
            <p class="error"><?php echo htmlspecialchars($error_message); ?></p>
        <?php } ?>
        <form action="product_register.php" method="post">
            <label>Email:</label>
            <input type="text" name="email" />
            <input type="submit" value="Login" /><br />
        </form>
    </main>
    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>