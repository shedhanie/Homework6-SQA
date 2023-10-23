package objectRepository;

import org.openqa.selenium.By;

public class pageProduct {
    By button_addCart = By.xpath("//button[contains(text(),'Add to cart')]");
    By amount_product = By.className("shopping_cart_badge");
    public By getButton_addCart() { return button_addCart; }
    public By getAmount_product() { return amount_product; }
}
