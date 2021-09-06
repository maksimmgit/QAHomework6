package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$$x;

public class CatalogPage {


    @FindBy(xpath = "//ul[@class='schema-filter__list']//span[text()='Samsung']")
    private SelenideElement samsungCheckbox;

    @FindBy(xpath = "//ul[@class='schema-filter__list']//span[text()='Xiaomi']")
    private SelenideElement xiaomiCheckbox;

    @FindBy(xpath = "//*[@id=\"schema-products\"]")
    private SelenideElement productsList;

    @FindBy(xpath = "//a[@data-bind='attr: {href: product.html_url}' and contains(@href, 'xiaomi')]")
    private SelenideElement allProducts;

    private ElementsCollection getAllProducts=
            $$x("//span[@data-bind='html: children.extended_name || children.full_name' and contains(text(), \"Xiaomi\")]");


    public void itemSamsungClick (){
        samsungCheckbox.scrollIntoView(true);
        samsungCheckbox.click();
        //System.out.println("samsung checkbox = " + samsungCheckbox.isSelected());

    }

    public void itemXiaomiClick(){
        xiaomiCheckbox.scrollIntoView(true);
        xiaomiCheckbox.click();
        //System.out.println("xiaomi checkbox = " + xiaomiCheckbox.isSelected());
    }


    public boolean searchText() {
        try {
            productsList.shouldNotHave(Condition.textCaseSensitive("Xiaomi"));
            return true;
        }catch (Exception e){
            System.out.println("hi");
            return false;
        }
    }

    public ElementsCollection allElements(){
/*        ElementsCollection collection = $$x("//a[@data-bind='attr: {href: product.html_url}' and contains(@href, 'xiaomi')]")
                .shouldHave()*/
        return getAllProducts;


    }

    public SelenideElement allProducts() {
        return allProducts;
    }

    public ElementsCollection SelenideWait(Conditional<WebDriver> input,
                                           long timeout,
                                           long pollingInterval){
        ElementsCollection collection = getAllProducts;
        System.out.println(collection.size());
        return getAllProducts;
    }






}
