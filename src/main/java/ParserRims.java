import model.Rims;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ParserRims implements ParserInteface, Runnable {
    private static WebDriver driver = null;
    private final Map<String, String> environment = System.getenv();
    static {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    ParserRims() {
        driver = new ChromeDriver();
        driver.get(environment.get("URL_PAGE_RIMS"));
    }


    public void run() {
        System.out.println(environment.get("URLNEXTBTN"));
        do {

            List<List<WebElement>> table = new ArrayList<>();
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM1"))));
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM2"))));
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM3"))));
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM4"))));
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM5"))));
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM6"))));
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM7"))));
            table.add(driver.findElements(By.xpath(environment.get("XPATHCOLLUM8"))));


            for (int i = 0; i < table.get(1).size(); i++) {
                Configuration configuration = new Configuration().addAnnotatedClass(Rims.class);
                SessionFactory sessionFactory= configuration.buildSessionFactory();
                try {

                    Session session = sessionFactory.getCurrentSession();
                    session.beginTransaction();
                    Rims rims = new Rims(table.get(0).get(i).getText(),
                            table.get(1).get(i).getText(),
                            table.get(2).get(i).getText(),
                            table.get(3).get(i).getText(),
                            table.get(4).get(i).getText(),
                            table.get(5).get(i).getText(),
                            table.get(6).get(i).getText(),
                            table.get(7).get(i).getText());

                    session.persist(rims);
                    session.getTransaction().commit();

                } catch (HibernateException e) {
                    throw new RuntimeException(e);
                }finally {
                    sessionFactory.close();
                }
            }
        } while (clickNext(environment.get("URLNEXTBTN"), driver));

    }
}