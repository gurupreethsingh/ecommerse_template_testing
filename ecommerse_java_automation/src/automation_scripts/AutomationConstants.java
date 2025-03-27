package automation_scripts;

public interface AutomationConstants 
{
    String urlOfHomepage = "http://localhost:5173";
    
    String urlOfLogin = "http://localhost:5173/login";
    
    String rootFolder = System.getProperty("user.dir");
    
    String excelSheetPath = rootFolder + "project_documents.xlsx";
    
    String screenshotFolder = rootFolder + "/failed_screehshots";
    
}
