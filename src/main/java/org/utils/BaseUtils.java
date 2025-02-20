package org.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtils {

	public static WebDriver driver;


//		public static void setUp() {
//			BrowserSetup bs = new BrowserSetup();
//			driver = bs.getDriver();
//			driver.manage().window().maximize();
//		}

		public static void launchUrl(String url) {
			try {
				driver.get(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static WebElement findElement(String xpath) {
			WebElement element = null;
			try {
				element = driver.findElement(By.xpath(xpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;
		}
		
		public static WebElement findElementtttttt(By by) {
			WebElement element = null;
			try {
				element = driver.findElement(by);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;
		}
		
		public static WebElement findElement(By by) {
			WebElement element = null;
			try {
				element = driver.findElement(by);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;
		}

		public static List<WebElement> findElements(String xpath) {
			List<WebElement> element = null;
			try {
				element = driver.findElements(By.xpath(xpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;
		}

		public static void clearElement(String xpath) {
			try {
				WebElement element = findElement(xpath);
				element.clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void clickOnElement(String xpath) {
			try {
				WebElement element = findElement(xpath);
				element.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void enterText(String xpath, String Data) {
			try {
				WebElement element = findElement(xpath);
				element.sendKeys(Data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void jsEnterText(String element, String Data) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].value='"+ Data +"';", element);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		public static String getAttribute(String xpath, String attributeName) {
			String ActualData = "";
			try {
				WebElement element = findElement(xpath);
				ActualData = element.getAttribute(attributeName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ActualData;
		}

		public static String getText(String xpath) {
			String ActualData = "";
			try {
				WebElement element = findElement(xpath);
				ActualData = element.getText();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ActualData;
		}

		public static boolean isDisplayed(String xpath) {
			boolean displayed = false;
			try {
				WebElement element = findElement(xpath);
				displayed = element.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return displayed;
		}

		public static boolean isEnabled(String xpath) {
			boolean enabled = false;
			try {
				WebElement element = findElement(xpath);
				enabled = element.isEnabled();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return enabled;
		}

		public static boolean isSelected(String xpath) {
			boolean selected = false;
			try {
				WebElement element = findElement(xpath);
				selected = element.isSelected();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return selected;
		}

		public static void dropDown(String xpath, String values) {
			try {
				WebElement element = findElement(xpath);
				Select select = new Select(element);
				String[] split = values.split("=");
				String type = split[0];
				String value = split[1];

				switch (type.toLowerCase()) {
				case "index":
					select.selectByIndex(Integer.parseInt(value));
					break;

				case "value":
					select.selectByValue(value);
					break;

				case "text":
					select.selectByVisibleText(value);
					break;

				default:
					System.out.println("Not Matched");
					break;
				}

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static List<String> getTextInList(String xpath) {
			List<String>ActText = new ArrayList<String>();
			try {
				List<WebElement> elements = findElements(xpath);
				for(int i=0; i<elements.size(); i++) {
					String text = elements.get(i).getText().trim();
					ActText.add(text);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ActText;
		}

		public static void multiSelect(String xpath, List<String> list) {
			try {
				WebElement element = findElement(xpath);
				Select s = new Select(element);
				for(int i=0; i<list.size(); i++) {
					s.selectByVisibleText(list.get(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void moveToElement(String xpath) {
			Actions action = new Actions(driver);
			try {
				WebElement element = findElement(xpath);
				action.moveToElement(element).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void doubleClick(String xpath) {
			Actions action = new Actions(driver);
			try {
				WebElement element = findElement(xpath);
				action.doubleClick(element).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void dragAndDrop(String source, String target) {
			Actions action = new Actions(driver);
			try {
				WebElement sourceElement = findElement(source);
				WebElement targetElement = findElement(target);
				action.dragAndDrop(sourceElement, targetElement).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void scrollDown(String xpath) {
			try {
				WebElement element = findElement(xpath);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void scrollUp(String xpath) {
			try {
				WebElement element = findElement(xpath);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].ScrollIntoView(false)", element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void scrollUP(String xpath) {
			try {
				WebElement element = findElement(xpath);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].ScrollIntoView(false)", element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void switchWindow() {
			try {
				Set<String> windowHandles = driver.getWindowHandles();
				for (String x : windowHandles) {
					driver.switchTo().window(x);
					String actTitle = driver.getTitle();
					System.out.println(actTitle);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void switchWindow(String ExpTitle) {
			try {
				Set<String> windowHandles = driver.getWindowHandles();
				for (String x : windowHandles) {
					driver.switchTo().window(x);
					String actTitle = driver.getTitle();
					System.out.println(actTitle);
					if (actTitle.equals(ExpTitle)) {
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static boolean alertPresent() {
			boolean status = false;
			try {
				WebDriverWait w = new WebDriverWait(driver, 30);
				Alert alert = w.until(ExpectedConditions.alertIsPresent());
				if (alert != null) {
					status = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

		public static void alertAccept() {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void alertDismiss() {
			try {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void alertgetText() {
			try {
				Alert alert = driver.switchTo().alert();
				alert.getText();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void alertSendKeys(String data) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void jsClickElement(String xpath) {
			try {
				WebElement element = findElement(xpath);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void jsClearElement(String xpath) {
			try {
				WebElement element = findElement(xpath);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].clear();", element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void switchFrames(String xpath) {
			try {
				WebElement element = findElement(xpath);
				driver.switchTo().frame(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void switchDefaultContent() {
			try {
				driver.switchTo().defaultContent();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void quit() {
			try {
				driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void close() {
			try {
				driver.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
}

