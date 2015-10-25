{"url":"jdbc:mysql://127.0.0.1:3306/", "dbName" = "StockEngine", "userName":"StockEngine", "password":"dietcoke"}

select q.symbol Sym, q.description Description
,q.lastTrade, q.prevClose, q.avgVolume, q.volume, q.mktCap, q.peRatio, q.priceChange, q.eps
, s.techScore, s.fundPoints, (s.techScore+s.fundPoints)/2 totalScore
, t.symbol InTop10
from StockEngine.ScreenResult r
left outer join StockEngine.Score s on s.symbol=r.symbol
left outer join StockEngine.Quote q on q.symbol=r.symbol
left outer join StockEngine.ScreenResult t on t.symbol=r.symbol and t.screenName='Top10'
where r.screenName='$SCREEN_NAME$'
order by (techscore+fundPoints) DESC




