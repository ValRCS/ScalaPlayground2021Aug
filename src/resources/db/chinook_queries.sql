--1. Provide a query showing Customers 
--(just their full names, customer ID and country) who are not in the US.
--SELECT c.FirstName , c.LastName , c.CustomerId , c.Country FROM customers c 
--WHERE c.Country != 'USA'
--ORDER BY c.Country ASC;

--2. brazil_customers.sql: Provide a query only showing the Customers from Brazil.
--SELECT * FROM customers c 
--WHERE c.Country = "Brazil";

--3. brazil_customers_invoices.sql: 
--Provide a query showing the Invoices of customers who are from Brazil. 
--The resultant table should show the customer's full name, 
--Invoice ID, Date of the invoice and billing country.


--SELECT
--    Name, 
--    Title
--FROM
--    artists
--    -- so we get all left rows but right row might not have a match
--JOIN albums ON
--    artists.ArtistId = albums.ArtistId
--ORDER BY Name DESC;

--SELECT a3.AlbumId , a3.Title , a4.Name FROM albums a3 
----INNER JOIN artists a4 
--JOIN artists a4 -- here the same
--ON a3.ArtistId = a4.ArtistId
--WHERE a4.Name LIKE "B%"
--ORDER BY a4.Name ASC
--;
--get ll all albums by artists whose name starts with B
--ORDER THEM by artist name

--SELECT a3.AlbumId , a3.Title , a4.Name FROM albums a3 
----INNER JOIN artists a4 
--JOIN artists a4 -- here the same
--ON a3.ArtistId = a4.ArtistId -- without this it would join every row agains every row in these tables
--LIMIT 30;
--SELECT * FROM tracks t2
--LIMIT 30;
--SELECT * FROM albums a2
--LIMIT 20;
--SELECT * FROM artists a;