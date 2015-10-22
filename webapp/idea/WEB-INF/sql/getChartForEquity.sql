{"url":"jdbc:mysql://127.0.0.1:3306/", "dbName" = "StockEngine", "userName":"StockEngine", "password":"dietcoke"}

select date, open, close, low, high, volume from HistoryElement where Symbol='$SYMBOL$' order by date asc
