-- Part 1 a
SELECT firstName, lastName FROM customers 
WHERE firstName LIKE 'brown' OR lastName LIKE 'brown'

-- Part 1 b
UPDATE products SET discountPercent = 25, dateAdded = CURRENT_TIMESTAMP() 
WHERE listPrice > 2000

-- Part 1 c
INSERT INTO orders 
    (customerID, orderDate, shipAmount, taxAmount, shipDate, shipAddressID, 
    cardType, cardNumber, cardExpires, billingAddressID)
VALUES
    (3, CURRENT_TIMESTAMP(), 20, 23.56, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 1 WEEK), 
    3, 2, 4123123412341234, '05/2024', 3)

-- Part 1 d
DELETE FROM orders WHERE orderDate BETWEEN '2017/06/01' AND '2017/06/07'