<?php 
    //set default value of variables for initial page load
    if (!isset($word1)) { $word1 = ''; } 
    if (!isset($word2)) { $word2 = ''; } 
    if (!isset($word3)) { $word3 = ''; } 
    if (!isset($word4)) { $word4 = ''; }
?> 

<!DOCTYPE html>
<html>
<head>
    <title>Password Generator</title>
    <link rel="stylesheet" type="text/css" href="main.css">
    <!-- This little script just functions to reset the form as the default
         behavior of reset will reset the form to what the state was on loading
         which, in this case, includes the previously entered passwords -->
    <script type="text/javascript">
        function resetForm(myFormId) {
            var myForm = document.getElementById(myFormId);

            for (var i = 0; i < myForm.elements.length; i++) {
                if ('submit' != myForm.elements[i].type && 
                    'reset' != myForm.elements[i].type)
                {
                    myForm.elements[i].value = '';
                }
            }
        }
    </script>
</head>

<body>
    <main>
    <h1>Password Generator</h1>
    <?php if (!empty($error_message)) { ?>
        <p class="error"><?php echo htmlspecialchars($error_message); ?></p>
        
    <?php } ?>
    <form action="generate_password.php" method="post" id="password_form">

        <div id="data">
            <label>Word 1:</label>
            <input type="text" name="word1" 
                value="<?php echo htmlspecialchars($word1); ?>">
            <br>

            <label>Word 2:</label>
            <input type="text" name="word2"
                value="<?php echo htmlspecialchars($word2); ?>">
            <br>

            <label>Word 3:</label>
            <input type="text" name="word3"
                value="<?php echo htmlspecialchars($word3); ?>">
            <br>

            <label>Word 4:</label>
            <input type="text" name="word4"
                value="<?php echo htmlspecialchars($word4); ?>">
            <br>

        </div>

        <div id="buttons">
            <label>&nbsp;</label>
            <input type="reset" name="resetBtn" value="Reset" 
                onclick="resetForm('password_form'); return false;">
            <input type="submit" value="Submit"><br>
        </div>

    </form>


        
    </main>
</body>
</html>