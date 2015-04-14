# SpringScratchpad
A simple scratchpad project for exploring Spring Framework capabilities with inversion-of-control and aspect-oriented-programming.

Instructions for configuring the environment (AA-specific, assuming no Github functionality):

1. Download and install latest 64-bit version of Java SDK.
	a. Currently: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

2. Download and extract latest 64-bit version of Spring Tool Suite
	a. Consider extracting to an easy path (e.g. "C:\sts-bundle" such that STS is in "C:\sts-bundle\sts-<version>.RELEASE\sts.exe")
	b. Currently: http://dist.springsource.com/release/STS/3.6.4.RELEASE/dist/e4.4/spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64.zip

3. Configure STS Workspace
	a. Create a workspace folder (e.g. "D:\workspace")
	b. open STS 
	c. Point it to your workspace folder

4. Download scratchpad ZIP from https://github.com/crael/SpringScratchpad/archive/master.zip 
	a. Extract to your workspace folder (e.g. <workspace>\SpringScratchpad\src, etc.)

5. Import the project into STS
	a. File->Import
	b. Select General->Existing Projects into Workspace
	c. Next
	d. Select the root directory of the project (e.g. <workspace\SpringScratchpad)
	e. Finish

6. Fix project build paths
	a. Right-click SpringScratchpad project
	b. Select Build Path->Configure Build Path...
	c. Select "Libraries" tab
	d. Select all JAR files with an "x" icon (i.e. the JAR files that cannot be found)
	e. Press the "Remove" button
	f. Click the "Add JARs..." button
	g. Expand SpringScratchpad\lib\compile
	h. Select all JAR files and click "OK"
	i. Click the "Add JARs..." button
	j. Expand SpringScratchpad\lib\shared
	k. Select all JAR files and click "OK"
	l. Click the "OK" to close the the Properties window

7. Run unit tests
	a. In Package Explorer, right-click SpringScratchpad->test/unit/unit-test-src
	b. Select Run As->JUnit Test
	c. Verify that all the JUnit tests pass int he JUnit window

8. Run application
	a. In Package Explorer, right-click SpringScratchpad->src
	b. Select Run As->Java Application
	c. Verify that the application runs by inspecting the console output
