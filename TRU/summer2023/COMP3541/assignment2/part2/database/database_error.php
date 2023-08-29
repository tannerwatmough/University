<!DOCTYPE html>
<html>

<!-- the head section -->
<head>
    <title>SportsPro Technical Support | Database Error</title>
    <link rel="stylesheet" type="text/css" href="../main.css" />
</head>

<!-- the body section -->
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
        <!-- Taken from Chapter 4 Product Manager example -->
        <h1>Database Error</h1>
        <p>There was an error connecting to the database.</p>
        <p>The database must be installed as described in the appendix.</p>
        <p>MySQL must be running as described in chapter 1.</p>
        <p>Error message: <?php echo htmlspecialchars($error_message); ?></p>
        <p>&nbsp;</p>
    </main>

    <footer>
        <p>&copy; 2023 SportsPro Inc</p>
    </footer>
</body>
</html>