<?php 
    //set default value of variables for initial page load
    if (!isset($investment)) { $investment = ''; } 
    if (!isset($interest_rate)) { $interest_rate = ''; } 
    if (!isset($years)) { $years = ''; } 
?> 
<!DOCTYPE html>
<html>
<head>
    <title>Future Value Calculator</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>

<body>
    <main>
    <h1>Future Value Calculator</h1>
    <form action="" method="post">

        <div id="data">
            <label>Investment Amount:</label>
            <input type="number" name="investment" min="0.01" step="0.01"
                   value="<?php echo htmlspecialchars($investment); ?>">
            <br>

            <label>Yearly Interest Rate:</label>
            <input type="number" name="interest_rate" min="0.01" step="0.01"
                   value="<?php echo htmlspecialchars($interest_rate); ?>">
            <br>

            <label>Number of Years:</label>
            <input type="number" name="years" min="1"
                   value="<?php echo htmlspecialchars($years); ?>">
            <br>

            <!-- Adds a checkbox to form to select monthly compounding -->
            <label>Compound Interest Monthly:</label>
            <input type="checkbox" name="interest">
        </div>

        <div id="buttons">
            <label>&nbsp;</label>
            <input type="submit" value="Calculate"><br>
        </div>

    </form>

    <?php 
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Form submitted

            // get the data from the form
            $investment = filter_input(INPUT_POST, 'investment',
                FILTER_VALIDATE_FLOAT);
            $interest_rate = filter_input(INPUT_POST, 'interest_rate',
                FILTER_VALIDATE_FLOAT);
            $years = filter_input(INPUT_POST, 'years',
                FILTER_VALIDATE_INT);

            // check if yearly or monthly interest calculation
            $interest_period_flag = isset($_POST['interest']);

    
            // validate investment
            if ($investment === FALSE ) {
                $error_message = 'Investment must be a valid number.'; 
            } else if ( $investment <= 0 ) {
                $error_message = 'Investment must be greater than zero.'; 
            // validate interest rate
            } else if ( $interest_rate === FALSE )  {
                $error_message = 'Interest rate must be a valid number.'; 
            } else if ( $interest_rate <= 0 ) {
                $error_message = 'Interest rate must be greater than zero.'; 
            // validate years
            } else if ( $years === FALSE ) {
                $error_message = 'Years must be a valid whole number.';
            } else if ( $years <= 0 ) {
                $error_message = 'Years must be greater than zero.';
            } else if ( $years > 30 ) {
                $error_message = 'Years must be less than 31.';
            // set error message to empty string if no invalid entries
            } else {
                $error_message = ''; 
            }

            if (!empty($error_message)) {
                echo '<p class="error">';
                echo htmlspecialchars($error_message);
                echo '</p>';
            // Only will do the calculations and display if no error messages.
            } else {
                // If monthly compounding checked, do that future value calculation
                if($interest_period_flag) {
                    $future_value = $investment;
                    // convert years to months
                    $months = $years * 12; 
                    // convert yearly interest to monthly interest
                    $monthly_interest = $interest_rate / 12; 
                    for ($i = 1; $i <= $months; $i++) {
                        $future_value += $future_value * $monthly_interest * 0.01;
                    }
                    // sets interest period to monthly for display purposes
                    $interest_period = 'monthly';
                } 
                // If monthly not checked, do yearly compounding
                else {
                    $future_value = $investment;
                    for ($i = 1; $i <= $years; $i++) {
                        $future_value += $future_value * $interest_rate * .01; 
                    }
                    // sets interest period to yearly for display purposes
                    $interest_period = 'yearly';
                }

                // apply currency and percent formatting
                $investment_f = '$'.number_format($investment, 2);
                $yearly_rate_f = $interest_rate.'%';
                $future_value_f = '$'.number_format($future_value, 2);



                echo '<h2>Results</h2>';
                // Adds the text to indicate how interest is being calculated. 
                echo "<p>Interest rate is calculated ".$interest_period.".</p>";
                echo '<label>Investment Amount:</label>';
                echo "<span>".$investment_f."</span><br>";

                echo '<label>Yearly Interest Rate:</label>';
                echo "<span>".$yearly_rate_f."</span><br>";

                echo '<label>Number of Years:</label>';
                echo "<span>".$years."</span><br>";

                echo '<label>Future Value:</label>';
                echo "<span>".$future_value_f."</span><br>";
            }
        }
    ?>

    </main>
</body>
</html>