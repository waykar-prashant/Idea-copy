{"url":"jdbc:mysql://127.0.0.1:3306/", "dbName" = "StockEngine", "userName":"StockEngine", "password":"dietcoke"}

select h.symbol SYMBOL, h.quantity QUANTITY, p.name PORTFOLIO, p.owner OWNER, p.creationDate from HOLDING h  inner join PORTFOLIO p on p.PORTFOLIO_ID=h.portfolio_id where p.owner ='markw' order by p.portfolio_id ASC
