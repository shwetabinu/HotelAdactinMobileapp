package reportgeneration;
import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.adactin.Mobileapphoteladactin1.util.ScreenshotCapture;

/**
 * This class has method to create instance of an Extent report,
 * configure the format of the report and to retreive the report path where it is saved.
 * @author aswinvijayan
 *
 */
public class ExtentReportGenerator {
    private static ExtentReports extent;
    private static String reportFileName = "Test-Automaton-Report_"+ScreenshotCapture.getDateInStringFormat(new Date(),2)+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
  
    /**
     * The method calls the createInstance method to start building the report
     * @return ExtentReport object
     */
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    /**
     * Creates an extent report instance with the required configurations such as 
     * Theme, Encoding, Report name,TimeStamp format, etc
     * @return ExtentReport object
     */
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
       
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
		extent.setSystemInfo("OS", "Mac");
		extent.setSystemInfo("AUT", "QA");
 
        return extent;
    }
     
    /**
     * Create the report path where the report is to be saved.
     * @param path Path where the report is saved
     * @return String: reportFileLocation 
     */
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
 
}