select  name, capacity, commstatus, health, output, flowrate, efficiency from Energisa.generator where siteName='$SITE_NAME$'
order by name ASC;

