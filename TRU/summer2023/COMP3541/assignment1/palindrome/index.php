<?php 
    //set default value of variables for initial page load
    if (!isset($palindrome_test)) { $palindrome_test = ''; } 
?> 
<!DOCTYPE html>
<html>
<head>
    <title>Palindrome Tester</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>

<body>
    <main>
    <h1>Palindrome Tester</h1>
    <form action="" method="post">

        <div id="data">
            <label>Type a string for palindrome testing:</label>
            <input type="text" name="palindrome_test" 
                value="<?php echo htmlspecialchars($palindrome_test); ?>">
            <br>

        </div>

        <div id="buttons">
            <label>&nbsp;</label>
            <input type="reset" value="Reset">
            <input type="submit" value="Submit"><br>
        </div>

    </form>

    <?php 
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Form submitted

            // get the data from the form
            $palindrome_test = filter_input(INPUT_POST, 'palindrome_test');

            $palindrome_f = strtolower($palindrome_test);

            // validate name
            if (strlen($palindrome_f) <= 1) {
                $error_message = 'String must have at least two characters.';          
            // set error message to empty string if no invalid entries
            } else {
                $error_message = ''; 
            }
            
            if (!empty($error_message)) {
                echo '<p class="error">';
                echo htmlspecialchars($error_message);
                echo '</p>';
            // Only will do the message and display if no error messages.
            } else {
                // testing for perfect palindrome
                if (strrev($palindrome_f) == $palindrome_f) {
                    $perfect_flag = true;
                } else {
                    $perfect_flag = false;
                }

                // testing for standard palindrome
                $palindrome_f = trim($palindrome_f);
                $palindrome_f = str_replace('.', '', $palindrome_f);
                $palindrome_f = str_replace('-', '', $palindrome_f);
                $palindrome_f = str_replace('(', '', $palindrome_f);
                $palindrome_f = str_replace(')', '', $palindrome_f);
                $palindrome_f = str_replace(' ', '', $palindrome_f);
                $palindrome_f = str_replace('+', '', $palindrome_f);
                $palindrome_f = str_replace(',', '', $palindrome_f);
                $palindrome_f = str_replace('"', '', $palindrome_f);
                $palindrome_f = str_replace('\'', '', $palindrome_f);
                $palindrome_f = str_replace(';', '', $palindrome_f);
                $palindrome_f = str_replace('?', '', $palindrome_f);
                $palindrome_f = str_replace('!', '', $palindrome_f);

                if (strrev($palindrome_f) == $palindrome_f) {
                    $standard_flag = true;
                } else {
                    $standard_flag = false;
                }

                // Display results
                echo '<h2>Result:</h2>';
                echo "<p>$palindrome_test is ";
                if (!$standard_flag) {
                    echo "NOT ";
                }
                echo 'a standard palindrome.<br>';
                echo "$palindrome_test is ";
                if (!$perfect_flag) {
                    echo "NOT ";
                }
                echo 'a perfect palindrome.';
            }
        }
    ?>
        
    </main>
</body>
</html>
