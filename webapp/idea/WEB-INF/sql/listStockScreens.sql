{"url":"jdbc:mysql://127.0.0.1:3306/", "dbName" = "StockEngine", "userName":"StockEngine", "password":"dietcoke"}

select r.screenName, round(avg(s.techScore),0) TECHNICAL, round(avg(s.fundPoints),0) FUNDAMENTAL, ROUND((avg(s.techScore)*1.0+avg(s.fundPoints)*0.5)/1.5,0) SCORE
, DATE_FORMAT(u.lastUpdate,'%W %M %d') lastUpdate from StockEngine.ScreenResult r
left outer join StockEngine.Score s on s.symbol=r.symbol
left outer join LastUpdated u on u.symbol=r.screenName
group by r.screenName
order by ROUND((avg(s.techScore)+avg(s.fundPoints)),0) DESC

