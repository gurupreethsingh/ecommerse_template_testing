package homepage_normal_automation_gurupreeth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O6_OpenSearchpageWithQueryText {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            // === Setup ===
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // === Read Data from Excel ===
            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);

            // === Open Homepage ===
            driver.get(websiteUrl);
            System.out.println("Navigated to: " + websiteUrl);

            // === Verify Homepage Title ===
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

            // === Locate search field Link ===
            WebElement searchField = driver.findElement(By.xpath("//form[contains(@class,'max-w-2xl')]/input"));
            //WebElement searchField = driver.findElement(By.cssSelector("form input[type='text']"));

            String inputText = "Peenut laddu";
            searchField.sendKeys(inputText);
            Thread.sleep(2000);

            // click on the search icons.
            WebElement searchIcon = driver.findElement(By.xpath("(//form//button[@type='submit'])[1]"));
            //WebElement searchIcon = driver.findElement(By.cssSelector("form input[type='text']"));


            searchIcon.click();


//            // === Post-click: Verify URL or Title again ===
//            String expectedSearchpageTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
            String expectedSearchpageTitle = "Search-Products | ECODERS";
//            String expectedSearchpageUrl   = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            String expectedSearchpageUrl = "http://localhost:5173/search-products?query=Peenut%20laddu";
            All_Verifications.verifyTitleMatch(expectedSearchpageTitle, driver, sa);
            All_Verifications.verifyUrleMatch(expectedSearchpageUrl, driver, sa);

         // Wait for heading to load (optional wait block can be added)
            WebElement heading = driver.findElement(By.xpath("//div[@class='flex items-center justify-between mb-6']/h1"));
            String actualHeadingText = heading.getText().trim();
            String expectedHeading = "Results for \"" + inputText + "\"";

            System.out.println("Expected Heading: " + expectedHeading);
            System.out.println("Actual Heading:   " + actualHeadingText);

            All_Verifications.verifyTextPresent(expectedHeading, driver, sa);

        } catch (Exception ex) {
            ex.printStackTrace();
            sa.fail("Test execution failed due to an exception: " + ex.getMessage());
        } finally {
            try {
                sa.assertAll();
            } catch (AssertionError ae) {
                ae.printStackTrace();
            } finally {
                try {
                    if (driver != null) {
                        driver.quit();
                        System.out.println("Browser closed successfully.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed to close browser.");
                }
            }
        }

    }
}
