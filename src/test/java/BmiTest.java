import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class BmiTest {

    @Test
    public void checkUsUnits() {

        // установить системную переменную
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // открыть браузер
        WebDriver driver = new ChromeDriver();
        // открыть сайт https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");
        // ввести вес
        WebElement weightInput = driver.findElement(By.name("wg"));
        weightInput.sendKeys("58");
        // ввести рост
        WebElement heightInput = driver.findElement(By.name("ht"));
        heightInput.sendKeys("178");
        // Нажать Calculate
        WebElement pushCalculateButton = driver.findElement(By.name("cc"));
        pushCalculateButton.click();
        // Проверить, что US Units = 18.61
        WebElement categoryInput = driver.findElement(By.name("us"));
        String actualNumber = categoryInput.getAttribute("value");

        assertEquals(actualNumber, "18.61", "Wrong number");
        driver.quit();
    }

    @Test
    public void categoryCheck () {

        // установить системную переменную
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // открыть браузер
        WebDriver driver = new ChromeDriver();
        // зайти на сайт
        driver.get("https://healthunify.com/bmicalculator/");
        // ввести вес в фунтах
        WebElement weightSetting = driver.findElement(By.name("opt1"));
        weightSetting.sendKeys("pounds");
        WebElement weight = driver.findElement(By.name("wg"));
        weight.clear();
        weight.sendKeys("40");
        // ввести рост в дюймах
        WebElement height = driver.findElement(By.name("opt2"));
        height.sendKeys ("5");
        WebElement height2 = driver.findElement(By.name("opt3"));
        height2.sendKeys("1");
        // нажать calculate
        WebElement clickButton = driver.findElement(By.name("cc"));
        clickButton.click();
        // проверить, что категория underweight
        WebElement categoryInput = driver.findElement(By.name("desc"));
        String actualCategory = categoryInput.getAttribute("value");

        assertEquals(actualCategory, "Your category is Underweight", "Category should be Underweight");
        driver.quit();
    }

    @Test
    public void categoryCheck2 () {

        // установить системную переменную
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // открыть браузер
        WebDriver driver = new ChromeDriver();
        // зайти на сайт
        driver.get("https://healthunify.com/bmicalculator/");
        // ввести вес в кг
        WebElement weightSetting = driver.findElement(By.name("wg"));
        weightSetting.sendKeys("60");
        // ввести рост в см
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys ("180");
        // нажать calculate
        WebElement clickButton = driver.findElement(By.name("cc"));
        clickButton.click();
        // проверить, что категория Obese
        WebElement categoryInput = driver.findElement(By.name("desc"));
        String actualCategory = categoryInput.getAttribute("value");


        assertEquals(actualCategory, "Your category is Normal", "Category should be Normal");
        driver.quit();
    }

    @Test
    public void ukUnitsCheck () {

        // установить системную переменную
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // открыть браузер
        WebDriver driver = new ChromeDriver();
        // зайти на сайт
        driver.get("https://healthunify.com/bmicalculator/");
        // ввести вес в фунтах
        WebElement weightSetting = driver.findElement(By.name("opt1"));
        weightSetting.sendKeys("pounds");
        WebElement weight = driver.findElement(By.name("wg"));
        weight.clear();
        weight.sendKeys("79");
        // ввести рост в дюймах
        WebElement height = driver.findElement(By.name("opt2"));
        height.sendKeys ("6");
        WebElement height2 = driver.findElement(By.name("opt3"));
        height2.sendKeys("4");
        // нажать calculate
        WebElement clickButton = driver.findElement(By.name("cc"));
        clickButton.click();
        // Проверить, что UK Units = 61.22
        WebElement categoryInput = driver.findElement(By.name("uk"));
        String actualNumber = categoryInput.getAttribute("value");

        assertEquals(actualNumber, "61.22", "Wrong number");
        driver.quit();
    }

    @Test
    public void checkCategory () {

        // установить системную переменную
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // открыть браузер
        WebDriver driver = new ChromeDriver();
        // зайти на сайт
        driver.get("https://healthunify.com/bmicalculator/");
        // ввести вес в кг
        WebElement weightSetting = driver.findElement(By.name("wg"));
        weightSetting.sendKeys("120");
        // ввести рост в см
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys ("193");
        // нажать calculate
        WebElement clickButton = driver.findElement(By.name("cc"));
        clickButton.click();
        // проверить, что категория Obese
        WebElement categoryInput = driver.findElement(By.name("desc"));
        String actualCategory = categoryInput.getAttribute("value");


        assertEquals(actualCategory, "Your category is Obese", "Category should be Obese");
        driver.quit();
    }
}
