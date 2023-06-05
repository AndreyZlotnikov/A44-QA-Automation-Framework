package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement plusBtn;
    //By plusBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement createNewPlaylist;
    //By createNewPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    @FindBy(css = ".create input")
    WebElement playlistNameInput;
    //By playlistNameInput = By.cssSelector(".create input");

    @FindBy(css = "[id='songResultsWrapper'] [placeholder='Playlist name']")
    WebElement plNameInput;
    //By plNameInput = By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']");

    @FindBy(css = "[href='#!/playlist/playlistNumber']")
    WebElement playlist;
    //By playlist59529 = By.cssSelector("[href='#!/playlist/59529']");

    @FindBy(css = "[data-testid='playlist-context-menu-edit-59529']")
    WebElement editBtn;
    //By editBtn = By.cssSelector("[data-testid='playlist-context-menu-edit-59529']");

    @FindBy(css = "input[name='name']")
    WebElement inputPlaylistName;
    //By inputPlaylistName = By.cssSelector("input[name=

    @FindBy(css = "[class='success show']")
    WebElement updatedBanner;
    //By updatedBanner = By.cssSelector("[class='success show']");

    public void createNewPlaylistWhileAddingSong(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(plNameInput);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }

    public void createNewPlaylistUsingPlusBtn(String playlistName) {
        WebElement plusButton = wait.until(ExpectedConditions.visibilityOfElementLocated(plusBtn));
        plusButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(createNewPlaylist)).click();
        // Add playlist name
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(playlistNameInput));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public void contextClickPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlist59529));
        WebElement playlistToRename = driver.findElement(playlist59529);
        Actions action = new Actions(driver);
        action.contextClick(playlistToRename).perform();
    }
    public WebElement editBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(editBtn));

    }
    public void clickEditBtnOfContextMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
    }
    public void enterNewPlaylistName() {

        String name = "Excellent songs";
        WebElement playlistToRename = driver.findElement(inputPlaylistName);
        playlistToRename.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistToRename.sendKeys(Keys.ENTER);
    }
    public WebElement updatedBanner() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(updatedBanner));

    }
    public String getPlaylistName() {
        WebElement playlist = driver.findElement(playlist59529);
        String playlistName = playlist.getText();
        return playlistName;
    }



}
