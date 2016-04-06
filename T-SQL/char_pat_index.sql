-- orders with addresses which do not start with a digit
select top 100 *
from Sales.Orders
where patindex('%[0-9]%', shipaddress) > 1;


-- orders with addresses which with 1
select top 100 *
from Sales.Orders
where charindex('1', shipaddress) = 1;
