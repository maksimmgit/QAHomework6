import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CatalogPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class OnlinerTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.startMaximized = true;
        Configuration.timeout = 10;

    }

    @ParameterizedTest
    @CsvSource({"Samsung, Xiaomi, Xiaomi"})
    public void testSamsungCheckbox(String samsungCheckbox, String xiaomiCheckbox, String searchText) throws InterruptedException {

        MainPage mainPage = open("https://onliner.by", MainPage.class);

        CatalogPage catalogPage = mainPage.catalogPage();


        catalogPage.itemSamsungClick();
        catalogPage.itemXiaomiClick();

        /*
        Не совсем понял как избавиться от .sleep. SelenideWait не совсем понял как правильно применять.
        Возможно, надо ещё потестить его использование.
         */
        Selenide.sleep(30000);
        //ElementsCollection collection = catalogPage.SelenideWait(Selenide.webdriver(),30000,3000);
        ElementsCollection collection = catalogPage.allElements();



        Assertions.assertEquals(60, collection.size());
        System.out.println("размер коллекции = " + collection.size());




    }
}
