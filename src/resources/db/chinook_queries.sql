SELECT
    Name, 
    Title
FROM
    artists
    -- so we get all left rows but right row might not have a match
JOIN albums ON
    artists.ArtistId = albums.ArtistId
ORDER BY Name DESC;

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