# SwagLabs - Test Automation - UI

								=======================
								Framework Architecture:
								=======================

Project - Maven

Framework - Page Object Model using Page Factory in Selenium.

Language - Java

WebDriver - 3.141 version

Browsers - Chrome

Test Executions - JUnit (or) maven test

Editor - Eclipse

=================
Folder Structure
=================

src/main/java - 1. Framework related codes (Method Of Execution [local], Selection Of Browser, Browser Invoking, Closing/Quiting Browser Instances, etc.,)
				2. Individual pages are classified in to their corresponding packages and written inside java file

src/main/resources - 1. Contains application config properties
					 2. log4j.xml file

src/test/java - Runners and Step Definitions Class Files

src/test/resources - Contains Feature Files

drverConfig - Chromedriver File

target - Contains Cucumer Test Result Report

test-output - Extent, Spark, Logs

pom.xml - Contains Project Dependencies, plugins, etc., 

===========
Executions:
=======
JUnit Test
==========
For running test:
 Right click on src/test/java/com/runners/TestRunner.java file> and Run As-> Junit Test
	(OR)
 Right click on pom.xml and Run As-> Maven test command as mvn clean -D test=TestRunner test 