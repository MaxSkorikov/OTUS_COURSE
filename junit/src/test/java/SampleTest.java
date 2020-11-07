import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class SampleTest {

    private static WebDriver DRIVER = null;
    private static final Logger LOGGER = LogManager.getLogger(SampleTest.class);
    private static final String EXPECTED_TITLE = "Онлайн‑курсы для профессионалов, " +
            "дистанционное обучение современным профессиям";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        DRIVER = new ChromeDriver();
        LOGGER.info("Драйвер поднят");
    }
    @Test
    public void openPage() {
        DRIVER.get("https://otus.ru/");
        LOGGER.info("Открыта страница отус");
        String actualTitle = DRIVER.getTitle();
        assertEquals(EXPECTED_TITLE, actualTitle);
        LOGGER.info("Title соответствует ожидаемому");
    }

    @After
    public void setDown() {
        if (DRIVER != null) {
            DRIVER.quit();
        }
    }
}










