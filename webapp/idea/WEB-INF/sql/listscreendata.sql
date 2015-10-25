select symbol, date, open, high, low, close, volume from StockEngine.HistoryElement
where symbol='$SYMBOL$'
order by date ASC
