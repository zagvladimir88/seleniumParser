import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ParserInteface {
    default  boolean clickNext(String xPath, WebDriver driver){

        try {
            WebElement nextBtn = driver.findElement(By.xpath(xPath));
            nextBtn.click();
        } catch (Exception e) {
            System.out.println("Больше нет страниц");
            driver.quit();
            return false;
        } return true;
    }
}
