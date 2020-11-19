@echo off
echo.
echo startup
echo.

cd %~dp0
cd ../huayi-admin/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% huayi-admin.jar

cd bin
pause