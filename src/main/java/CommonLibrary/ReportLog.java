package CommonLibrary;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;


public class ReportLog {
		public static String Log4J="D:\\testWorkspace\\HybridFramework\\log4j.properties";
		public static final Logger logger=Logger.getLogger(ReportLog.class.getName());
		
		public static void getlogger(){
			PropertyConfigurator.configure(Log4J);
		}
		

}
