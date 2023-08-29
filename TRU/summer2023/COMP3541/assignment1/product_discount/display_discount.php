<?php
    // get the data from the form
    $product_description = filter_input(INPUT_POST, 'product_description');
    // FILTER_VALIDATE_FLOAT prevents strings from crashing the PHP script.
    // However, the user should not be able to input strings regardless with
    // changing the input type to "number" and setting a step increment.  
    $list_price = filter_input(INPUT_POST, 'list_price', FILTER_VALIDATE_FLOAT);
    $discount_percent = filter_input(INPUT_POST, 'discount_percent', 
        FILTER_VALIDATE_FLOAT);

    // calculate the discount and discounted price
    $discount = $list_price * $discount_percent * .01;
    $discount_price = $list_price - $discount;

    // set sales tax here
    $SALES_TAX_PERCENT = 8;

    // calculate the sales tax and total price
    $sales_tax = $discount_price * $SALES_TAX_PERCENT * .01; 
    $total_price = $discount_price + $sales_tax;

    // apply currency formatting to the dollar and percent amounts
    $list_price_f = "$".number_format($list_price, 2);
    $discount_percent_f = $discount_percent."%";
    $discount_f = "$".number_format($discount, 2);
    $discount_price_f = "$".number_format($discount_price, 2);
    $sales_tax_percent_f = $SALES_TAX_PERCENT."%"; // sales tax percent
    $sales_tax_amount_f = "$".number_format($sales_tax, 2); // sales tax amount
    $total_price_f = "$".number_format($total_price, 2); // total price
?>
<!DOCTYPE html>
<html>

<head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>

<body>
    <main>
        <h1>Product Discount Calculator</h1>

        <label>Product Description:</label>
        <span><?php echo htmlspecialchars($product_description); ?></span>
        <br>

        <label>List Price:</label>
        <span><?php echo htmlspecialchars($list_price_f); ?></span>
        <br>

        <label>Standard Discount:</label>
        <span><?php echo htmlspecialchars($discount_percent_f); ?></span>
        <br>

        <label>Discount Amount:</label>
        <span><?php echo $discount_f; ?></span>
        <br>

        <label>Discount Price:</label>
        <span><?php echo $discount_price_f; ?></span>
        <br>

        <!-- Create new labels and display areas for sales tax info
             There is no need to use htmlspecialchars on the sales tax
             fields as they do not use any user inputted data (setting
             the sales tax must be down server side) -->
        <label>Sales Tax Rate:</label>
        <span><?php echo $sales_tax_percent_f; ?></span>
        <br>

        <label>Sales Tax Amount::</label>
        <span><?php echo $sales_tax_amount_f; ?></span>
        <br>

        <label>Total:</label>
        <span><?php echo $total_price_f; ?></span>
        <br>
    </main>
</body>
</html>