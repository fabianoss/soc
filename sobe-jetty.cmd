taskkill /f /im jqs.exe
taskkill /f /im javaw.exe
taskkill /f /im java.exe

set MAVEN_OPTS=-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n

mvn  -DskipTests clean install jetty:run 