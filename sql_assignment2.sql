-- General Metrics
-- 1. What is the total number of orders?
SELECT COUNT(*) AS TotalOrders FROM Orders;

-- 2. How many customers are there?
SELECT COUNT(DISTINCT CustomerID) AS TotalCustomers FROM Customers;

-- 3. What is the total revenue from all orders?
SELECT SUM(P.Price * O.Quantity) AS TotalRevenue
FROM OrderDetails O
JOIN Products P ON O.ProductID = P.ProductID;

-- Product and Sales Insights

-- 4. What are the top 5 best-selling products by quantity?
SELECT P.ProductName, SUM(O.Quantity) AS TotalQuantity
FROM OrderDetails O
JOIN Products P ON O.ProductID = P.ProductID
GROUP BY P.ProductName
ORDER BY TotalQuantity DESC
LIMIT 5;

-- 5. Which are the top 5 products by total revenue generated?
SELECT P.ProductName, SUM(O.Quantity * P.Price) AS TotalRevenue
FROM OrderDetails O
JOIN Products P ON O.ProductID = P.ProductID
GROUP BY P.ProductName
ORDER BY TotalRevenue DESC
LIMIT 5;

-- 6. What is the average revenue per product?
SELECT AVG(ProductRevenue) AS AvgRevenuePerProduct
FROM (
  SELECT P.ProductName, SUM(O.Quantity * P.Price) AS ProductRevenue
  FROM OrderDetails O
  JOIN Products P ON O.ProductID = P.ProductID
  GROUP BY P.ProductName
) AS Revenues;

-- 7. What is the total revenue generated per product category?
SELECT C.CategoryName, SUM(O.Quantity * P.Price) AS TotalRevenue
FROM OrderDetails O
JOIN Products P ON O.ProductID = P.ProductID
JOIN Categories C ON P.CategoryID = C.CategoryID
GROUP BY C.CategoryName;

-- 8. Which product categories have the highest average price per product?
SELECT C.CategoryName, AVG(P.Price) AS AvgPrice
FROM Products P
JOIN Categories C ON P.CategoryID = C.CategoryID
GROUP BY C.CategoryName
ORDER BY AvgPrice DESC;


-- Customer Analytics

-- 9. Who are the top 5 customers by purchase volume?
SELECT CU.CustomerName, SUM(O.Quantity * P.Price) AS TotalSpent
FROM Orders OD
JOIN Customers CU ON OD.CustomerID = CU.CustomerID
JOIN OrderDetails O ON OD.OrderID = O.OrderID
JOIN Products P ON O.ProductID = P.ProductID
GROUP BY CU.CustomerName
ORDER BY TotalSpent DESC
LIMIT 5;

-- 10. How many customers are there in each country?
SELECT Country, COUNT(*) AS CustomerCount
FROM Customers
GROUP BY Country;

-- 11. Which country contributes the most to total revenue?
SELECT CU.Country, SUM(O.Quantity * P.Price) AS TotalRevenue
FROM Orders OD
JOIN Customers CU ON OD.CustomerID = CU.CustomerID
JOIN OrderDetails O ON OD.OrderID = O.OrderID
JOIN Products P ON O.ProductID = P.ProductID
GROUP BY CU.Country
ORDER BY TotalRevenue DESC
LIMIT 1;

-- 12. What is the average order value per customer?
SELECT CU.CustomerName, AVG(OrderTotal) AS AvgOrderValue
FROM (
  SELECT OD.CustomerID, OD.OrderID, SUM(O.Quantity * P.Price) AS OrderTotal
  FROM Orders OD
  JOIN OrderDetails O ON OD.OrderID = O.OrderID
  JOIN Products P ON O.ProductID = P.ProductID
  GROUP BY OD.OrderID
) AS CustomerOrders
JOIN Customers CU ON CustomerOrders.CustomerID = CU.CustomerID
GROUP BY CU.CustomerName;

-- 13. Which customers placed more than 5 orders?
SELECT CU.CustomerName, COUNT(OD.OrderID) AS OrderCount
FROM Orders OD
JOIN Customers CU ON OD.CustomerID = CU.CustomerID
GROUP BY CU.CustomerName
HAVING OrderCount > 5;

-- Time-Based Analysis
-- 14. How many orders are placed each month?
SELECT DATE_FORMAT(OrderDate, '%Y-%m') AS Month, COUNT(*) AS OrderCount
FROM Orders
GROUP BY Month;

-- 15. What is the average order value per month?
SELECT DATE_FORMAT(OrderDate, '%Y-%m') AS Month, AVG(OrderTotal) AS AvgOrderValue
FROM (
  SELECT OD.OrderID, DATE_FORMAT(OD.OrderDate, '%Y-%m') AS Month, SUM(O.Quantity * P.Price) AS OrderTotal
  FROM Orders OD
  JOIN OrderDetails O ON OD.OrderID = O.OrderID
  JOIN Products P ON O.ProductID = P.ProductID
  GROUP BY OD.OrderID
) AS MonthlyOrders
GROUP BY Month;

-- 16. Which month had the highest number of orders?
SELECT DATE_FORMAT(OrderDate, '%Y-%m') AS Month, COUNT(*) AS OrderCount
FROM Orders
GROUP BY Month
ORDER BY OrderCount DESC
LIMIT 1;

-- Employee and Shipping Insights

-- 17. How many orders has each employee handled?
SELECT CONCAT(E.FirstName, ' ', E.LastName) AS EmployeeName, COUNT(O.OrderID) AS OrdersHandled
FROM Orders O
JOIN Employees E ON O.EmployeeID = E.EmployeeID
GROUP BY EmployeeName;

-- 18. Which employee generated the highest revenue?
SELECT CONCAT(E.FirstName, ' ', E.LastName) AS EmployeeName,
       SUM(OD.Quantity * P.Price) AS TotalRevenue
FROM Orders O
JOIN Employees E ON O.EmployeeID = E.EmployeeID
JOIN OrderDetails OD ON O.OrderID = OD.OrderID
JOIN Products P ON OD.ProductID = P.ProductID
GROUP BY EmployeeName
ORDER BY TotalRevenue DESC
LIMIT 1;

-- 19. How frequently has each shipper been used?
SELECT S.ShipperName, COUNT(O.OrderID) AS ShipmentCount
FROM Orders O
JOIN Shippers S ON O.ShipperID = S.ShipperID
GROUP BY S.ShipperName;

-- 20. Which shipper delivered the most revenue-generating orders?
SELECT S.ShipperName, SUM(OD.Quantity * P.Price) AS TotalRevenue
FROM Orders O
JOIN Shippers S ON O.ShipperID = S.ShipperID
JOIN OrderDetails OD ON O.OrderID = OD.OrderID
JOIN Products P ON OD.ProductID = P.ProductID
GROUP BY S.ShipperName
ORDER BY TotalRevenue DESC
LIMIT 1;