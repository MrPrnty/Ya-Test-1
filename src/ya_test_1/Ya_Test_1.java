/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ya_test_1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Александр
 */
public class Ya_Test_1 {

    /**
     * @param args the command line arguments
     */
    private static WebDriver driver = null;
    public static void main(String[] args) {
        // TODO code application logic here      
        System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\chromedriver_win32\\chromedriver.exe");              
        driver = new ChromeDriver();                
        driver.manage().window().maximize();         
        driver.get("https://yandex.ru");                 
        driver.findElement(By.linkText("Маркет")).click();               
        driver.findElement(By.linkText("Электроника")).click();             
        driver.findElement(By.linkText("Мобильные телефоны")).click();     
        driver.findElement(By.linkText("Перейти ко всем фильтрам")).click();        
        driver.findElement(By.cssSelector("#glf-pricefrom-var")).click();        
        driver.findElement(By.cssSelector("#glf-pricefrom-var")).sendKeys("20000");         
        driver.findElement(By.linkText("Apple")).click();         
        driver.findElement(By.linkText("Samsung")).click(); 
        driver.findElement(By.xpath("//html/body/div[1]/div[4]/div/div[1]/div[5]/a[2]")).click(); 
        List<WebElement> linkElements = driver.findElements(By.className("n-snippet-cell2__title"));        
        System.out.println("Элементов на странице: "+linkElements.size());
        WebElement FirstCell = linkElements.get(0);
        String FirstCell_name = FirstCell.getText();
        System.out.println("Первый элемент списка: "+FirstCell_name); 
        driver.findElement(By.cssSelector("#header-search")).click();
        driver.findElement(By.cssSelector("#header-search")).sendKeys(FirstCell_name); 
        driver.findElement(By.cssSelector("#header-search")).submit();   
        WebElement FirstCell_TS = driver.findElement(By.className("n-title__text"));  
        String FirstCell_TS_name = FirstCell_TS.getText(); 
        System.out.println("Найденный элемент: "+FirstCell_TS_name); 
        if (FirstCell_name == null ? FirstCell_TS_name == null : FirstCell_name.equals(FirstCell_TS_name)) 
             System.out.println("Название товара соответствует запомненному значению!");
        else 
            System.out.println("Название товара не соответствует запомненному значению!");
        driver.close();
    }
    
}
