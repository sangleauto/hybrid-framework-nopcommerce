cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllureReport\*;%ProjectPath%libExtentV5\*;%ProjectPath%libLog4J\*;%ProjectPath%libWebDriverManager5\*;%ProjectPath%libReportNG\*;%ProjectPath%libSelenium\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerceUser.xml"
pause