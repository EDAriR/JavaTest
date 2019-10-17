package sideProjectTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppiumAndroid1 {

    public static AndroidDriver driver;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

//        File app = new File("C:\\selenium\\AppiumAndroid\\Appium2.0\\app\\bk-mobile-native.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "Selendroid");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HT48NWZ02491");
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.dbs.cardplus.tw");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "controller.SplashActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // all android persmission ok
        capabilities.setCapability("autoGrantPermissions", "True");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        waitForElementPresent(By.id("button1"), 40);


        Thread.sleep(3000);

        // 資安提醒
        try {


            driver.findElement(By.id("button_ok")).click();
        }catch (Exception e){
            String msg = e.getMessage();

            System.out.println(msg);
        }

        try {
            driver.findElementByAndroidUIAutomator("new UiSelector().text(\"確認\")").click();
        }catch (Exception e){
            String msg = e.getMessage();

            System.out.println(msg);
        }


        Thread.sleep(3000);
        System.out.println("login test ==========");

        try {

            driver.findElement(By.id("button_login")).click();
            driver.findElement(By.id("edit_account")).sendKeys("account");
            driver.findElement(By.id("edit_mima")).sendKeys("password");
            driver.findElementByAndroidUIAutomator("new UiSelector().text(\"登入\")").click();
            driver.findElementByAndroidUIAutomator("new UiSelector().text(\"確認\")").click();

            System.out.println("login test end ==========");

        }catch (Exception e){
            String msg = e.getMessage();

            System.out.println(msg);
        }

        System.out.println("regis test ==========");

        try {

            driver.findElementByAndroidUIAutomator("new UiSelector().text(\"線上註冊\")").click();
            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
                    .sendKeys("A123456789");
            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
                    .click();
            driver.hideKeyboard();
//            driver.findElementByAndroidUIAutomator("new UiSelector().text(\"登入\")").click();
            driver.findElementByAndroidUIAutomator("new UiSelector().text(\"下一步\")").click();
        }catch (Exception e){
            String msg = e.getMessage();

            System.out.println(msg);
        }

        // /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText

        System.out.println("wake up =======>");


    }

    public static void waitForElementPresent(final By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        wait.until(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver d) {
                // TODO Auto-generated method stub
                return d.findElement(by).isDisplayed();
            }
        });
    }

}
