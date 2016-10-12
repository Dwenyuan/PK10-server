call C:\xampp\tomcat\bin\shutdown.bat
call mvn -DskipTests clean package
rd /S /Q C:\xampp\Tomcat\webapps\pk10
copy target\pk10.war C:\xampp\tomcat\webapps\
startup
pause