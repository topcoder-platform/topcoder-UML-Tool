1) this component required jfcunit to run test. you can download it from http://sourceforge.net/projects/jfcunit/
   and jfcunit needs jakarta-regexp lib, you can download it from http://jakarta.apache.org/

2) when running test, it will pop up some dialog box, such as print dialog box, you just need to click cancel or ok, and then tests will go on.

3) add system environment variable to build.xml
	For the test of printing result of FitInPagePrint and ScalingPrint, a helper class ImagePrinter is used. 
	It can print a Printable object into a JPG file. Before using this class, system environment variable 
	"PRINT_RESULT" should be specified to a valid local directory, eg. "e:\\temp". Afterwards, the generated 
	jpg files will be stored in this folder. If it's not specified, not jpg results will be generated.
	
	To specify the system environment variable in build.xml will be like this:
	
			<junit fork="true" haltonerror="false">
	        	<env key="PRINT_RESULT" value="${testfiles}/print_result"/> <!-- add here -->
	            <classpath refid="test.build.classpath"/>
	            <test name="${package}.AllTests" todir="${testlogdir}">
	                <formatter type="plain" usefile="true"/>
	                <formatter type="xml" usefile="true"/>
	            </test>
	        </junit>
	        
4) Print result:
	./test_files/print_result contains the printing result in PDF and JPG type.
	The pdf files are printing result of PrintManagerTest;
	The jpg files are printing result of ScalingPrintTest and ScalingPrintTest
	
