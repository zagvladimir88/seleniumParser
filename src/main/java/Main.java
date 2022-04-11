import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

final class XPathUrl {
    //url of click button next page
    public static String URLNEXTBTN = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/table/tbody/tr/td[*]/a[@class=\"next i-next\"]";

    //url of page for parsing
    public static String URL_PAGE_TIRES = "https://shop.bohnenkamp.by/tyres.html";
    public static String URL_PAGE_WHEELS = "https://shop.bohnenkamp.by/wheels.html";
    public static String URL_PAGE_TUBES = "https://shop.bohnenkamp.by/tubes.html";
    public static String URL_PAGE_RIMS = "https://shop.bohnenkamp.by/rims.html";
    public static String URL_PAGE_VEHICLECONSTRUCTIONS = "https://shop.bohnenkamp.by/vehicle-construction.html";
    public static String URL_PAGE_SPECIALITEMS = "https://shop.bohnenkamp.by/specialitems/";

    //url of elements for parsing
    public static String XPATHCOLLUM1 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[2]";
    public static String XPATHCOLLUM2 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[3]";
    public static String XPATHCOLLUM3 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[4]";
    public static String XPATHCOLLUM4 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[5]";
    public static String XPATHCOLLUM5 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[6]";
    public static String XPATHCOLLUM6 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[7]";
    public static String XPATHCOLLUM7 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[8]";
    public static String XPATHCOLLUM8 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[9]";
    public static String XPATHCOLLUM9 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[10]";
    public static String XPATHCOLLUM10 = "/html/body/div[1]/div/div[3]/div/div[2]/div[3]/table/tbody/tr/td[11]";

    //mysql parameters
    public static String USER_NAME = "root";
    public static String PASSWORD = "6693";
    public static String CONNECTION_URL = "jdbc:mysql://localhost:3306/mysql";
}

class ParserTire implements ParserInteface, Runnable {
    private static WebDriver driver = null;
    final private AddTableToSql sql = new AddTableToSql(XPathUrl.USER_NAME, XPathUrl.PASSWORD, XPathUrl.CONNECTION_URL);

    static {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    ParserTire() {
        driver = new ChromeDriver();
        driver.get(XPathUrl.URL_PAGE_TIRES);
    }


    public void run() {
        do {
            List<List<WebElement>> table = new ArrayList<>();
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM1)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM2)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM3)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM4)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM5)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM6)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM7)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM8)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM9)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM10)));

            for (int i = 0; i < table.get(1).size(); i++) {
                try {
                    sql.executeToSQL(table, "insert into tires.tiresnew(ArtNm,GoodsGroup,SizeTires,RD,TLTT,LESI,PR,Treat,Producer,Specifications)" +
                            "values(" + "'" + table.get(0).get(i).getText() + "','" + table.get(1).get(i).getText() + "','" + table.get(2).get(i).getText() +
                            "','" + table.get(3).get(i).getText() + "','" + table.get(4).get(i).getText() + "','" + table.get(5).get(i).getText() +
                            "','" + table.get(6).get(i).getText() + "','" + table.get(7).get(i).getText() + "','" + table.get(8).get(i).getText() +
                            "','" + table.get(9).get(i).getText() + "')");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } while (clickNext(XPathUrl.URLNEXTBTN, driver));
    }
}

class ParserWheel implements ParserInteface, Runnable {
    private static WebDriver driver = null;
    final private AddTableToSql sql = new AddTableToSql(XPathUrl.USER_NAME, XPathUrl.PASSWORD, XPathUrl.CONNECTION_URL);


    static {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    ParserWheel() {
        driver = new ChromeDriver();
        driver.get(XPathUrl.URL_PAGE_WHEELS);
    }

    public void run() {
        do {
            List<List<WebElement>> table = new ArrayList<>();
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM1)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM2)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM3)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM4)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM6)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM7)));

            for (int i = 0; i < table.get(0).size(); i++) {
                try {
                    sql.executeToSQL(table, "insert into tires.wheels(ArtNm,GoodsGroup,applicability,whhelsize,RD,producer)" +
                            "values(" + "'" + table.get(0).get(i).getText() + "','" + table.get(1).get(i).getText() + "','" + table.get(2).get(i).getText() +
                            "','" + table.get(3).get(i).getText() + "','" + table.get(4).get(i).getText() + "','" + table.get(5).get(i).getText() + "')");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } while (clickNext(XPathUrl.URLNEXTBTN, driver));
    }
}

class ParserTubes implements ParserInteface, Runnable {
    private static WebDriver driver = null;
    final private AddTableToSql sql = new AddTableToSql(XPathUrl.USER_NAME, XPathUrl.PASSWORD, XPathUrl.CONNECTION_URL);

    static {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    ParserTubes() {
        driver = new ChromeDriver();
        driver.get(XPathUrl.URL_PAGE_TUBES);
    }

    public void run() {
        do {
            List<List<WebElement>> table = new ArrayList<>();
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM1)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM2)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM3)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM4)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM6)));

            for (int i = 0; i < table.get(0).size(); i++) {
                try {
                    sql.executeToSQL(table, "insert into tires.tubes(ArtNm,GoodsGroup,wheelrim,producer,specifications)" +
                            "values(" + "'" + table.get(0).get(i).getText() + "','" + table.get(1).get(i).getText() + "','" + table.get(2).get(i).getText() +
                            "','" + table.get(3).get(i).getText() + "','" + table.get(4).get(i).getText() + "')");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } while (clickNext(XPathUrl.URLNEXTBTN, driver));
    }
}

class ParserRims implements ParserInteface, Runnable {
    private static WebDriver driver = null;
    final private AddTableToSql sql = new AddTableToSql(XPathUrl.USER_NAME, XPathUrl.PASSWORD, XPathUrl.CONNECTION_URL);

    static {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    ParserRims() {
        driver = new ChromeDriver();
        driver.get(XPathUrl.URL_PAGE_RIMS);
    }


    public void run() {
        do {
            List<List<WebElement>> table = new ArrayList<>();
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM1)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM2)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM3)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM4)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM5)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM6)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM7)));
            table.add(driver.findElements(By.xpath(XPathUrl.XPATHCOLLUM8)));


            for (int i = 0; i < table.get(1).size(); i++) {
                try {
                    sql.executeToSQL(table, "insert into tires.rims(ArtNm,GoodsGroup,rimsize,numofhols,hubhol,pcd,vilet,color)" +
                            "values(" + "'" + table.get(0).get(i).getText() + "','" + table.get(1).get(i).getText() + "','" + table.get(2).get(i).getText() +
                            "','" + table.get(3).get(i).getText() + "','" + table.get(4).get(i).getText() + "','" + table.get(5).get(i).getText() +
                            "','" + table.get(6).get(i).getText() + "','" + table.get(7).get(i).getText()+"')");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } while (clickNext(XPathUrl.URLNEXTBTN, driver));
    }
}

class AddTableToSql {
    String userName;
    String password;
    String connectionUrl;

    public AddTableToSql(String userName, String password, String connectionUrl) {

        this.userName = userName;
        this.password = password;
        this.connectionUrl = connectionUrl;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeToSQL(List<List<WebElement>> tableElements, String sqlQuery) throws ClassNotFoundException, SQLException {
        List<List<WebElement>> table = tableElements;

        Statement statement = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            statement = connection.createStatement();

            for (int i = 0; i < table.get(1).size(); i++) {
                try {
                    statement.executeUpdate(sqlQuery);
                } catch (SQLIntegrityConstraintViolationException e) {
                    continue;
                }
            }
        } finally {
            statement.close();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ParserTire parserTire = new ParserTire();
        ParserWheel parserWheel = new ParserWheel();
        ParserTubes parserTubes = new ParserTubes();
        ParserRims parserRims = new ParserRims();


        Thread thread1 = new Thread(parserTire);
        Thread thread2 = new Thread(parserWheel);
        Thread thread3 = new Thread(parserTubes);
        Thread thread4 = new Thread(parserRims);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершенно успешно");
    }
}

