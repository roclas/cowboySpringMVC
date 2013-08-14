roo script CreateRooProject.roo

mysql test < conf/users.sql
cp conf/persistence.xml ./src/main/resources/META-INF/persistence.xml 
cp conf/applicationContext-security.xml ./src/main/resources/META-INF/spring/applicationContext-security.xml

mvn jetty:run
