select s.name, sum(g.capacity) capacity, sum(g.output) output, avg(g.flowrate) flowrate, avg(g.efficiency) efficiency, s.commStatus, s.health, s.latitude, s.longitude from Energisa.Site s
inner join Energisa.generator g on g.siteName=s.name
group by s.name
