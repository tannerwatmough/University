<?php
    // get the data from the form
    $word1 = filter_input(INPUT_POST, 'word1');
    $word2 = filter_input(INPUT_POST, 'word2');
    $word3 = filter_input(INPUT_POST, 'word3');
    $word4 = filter_input(INPUT_POST, 'word4');

    $word1_uc = strtoupper($word1);
    $word2_uc = strtoupper($word2);
    $word3_uc = strtoupper($word3);
    $word4_uc = strtoupper($word4);

    // sets pattern to be only alphabetical characters. 
    $pattern = "/^[A-Z]{4,7}$/";
    
    // validate that all words entered, are between 4 and 7 characters, and 
    // contain only letters. 
    if (strlen($word1_uc) < 4 || strlen($word1_uc) > 7) {
        $error_message = 'Word 1 must be between 4 and 7 characters.'; 
    } else if (preg_match($pattern, $word1_uc) === 0)  {
        $error_message = 'Word 1 must contain only letters.'; 
    // Word 2
    } else if (strlen($word2_uc) < 4 || strlen($word2_uc) > 7) {
        $error_message = 'Word 2 must be between 4 and 7 characters.'; 
    } else if (preg_match($pattern, $word2_uc) === 0)  {
        $error_message = 'Word 2 must contain only letters.';
    // Word 3 
    } else if (strlen($word3_uc) < 4 || strlen($word3_uc) > 7) {
        $error_message = 'Word 3 must be between 4 and 7 characters.'; 
    } else if (preg_match($pattern, $word3_uc) === 0)  {
        $error_message = 'Word 3 must contain only letters.'; 
    // Word 4
    } else if (strlen($word4_uc) < 4 || strlen($word4_uc) > 7) {
        $error_message = 'Word 4 must be between 4 and 7 characters.'; 
    } else if (preg_match($pattern, $word4_uc) === 0)  {
        $error_message = 'Word 4 must contain only letters.'; 
    } 
    // set error message to empty string if no invalid entries
    else {
        $error_message = ''; 
    }

    // if an error message exists, go to the index page
    if ($error_message != '') {
        include('index.php');
        exit(); 
    }

    // create passwords
    $password1 = str_shuffle($word1_uc);
    $password2 = str_shuffle($word2_uc);
    $password3 = str_shuffle($word3_uc);
    $password4 = str_shuffle($word4_uc);

?>
<!DOCTYPE html>
<html>
<head>
    <title>Password Generator</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
    <main>
        <h1>Password Generator</h1>

        <label>Password 1:</label>
        <span><?php echo $password1; ?></span><br>

        <label>Password 2:</label>
        <span><?php echo $password2; ?></span><br>

        <label>Password 3:</label>
        <span><?php echo $password3; ?></span><br>

        <label>Password 4:</label>
        <span><?php echo $password4; ?></span><br>
    </main>
</body>
</html>
