package com.nttdata.ct.web;

import com.nttdata.ct.web.task.ExcelData;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

public class Util {
    public static void doubleClic(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element)
                .click()
                .click()
                .build()
                .perform();
    }

    public static void tab(WebDriver driver) {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB).build().perform();
    }

    public static void press(WebDriver driver, WebElement element, String var) {
        Actions act = new Actions(driver);
        act.sendKeys(element, var).perform();
    }

    public static void pressBackspace(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        element.sendKeys(Keys.CONTROL + "a");
        act.sendKeys(element, Keys.DELETE).perform();
//        act.sendKeys(element, var).perform();
    }
    public static void up(WebDriver driver) {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ARROW_UP).build().perform();
    }
    public static void enter(WebDriver driver) {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).build().perform();
    }

    public static void tripleClic(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element)
                .click()
                .click()
                .build()
                .perform();
    }

    public static void explicitWait(int timeOnSeconds) {
        try {
            Thread.sleep(timeOnSeconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void isVisibleAlertRFCCreate(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert.getText());
            String name = alert.getText();
            if (name.contains("")) {
                alert.accept();
            } else {
                System.out.println("No apareció la alerta");
            }
        } catch (Throwable e) {
            System.out.println("No apareció la alerta");
        }
    }

    public static void waitWebElementIsEnabled(int sec,WebDriver driver, WebElement element) {
        try {WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            wait.until((ExpectedCondition<Boolean>) drive -> element.isEnabled());
        } catch (Exception e) {
            System.out.println("No se habilito el elemento");
        }
    }

    public static boolean webElementIsEnabled(int segundos,WebDriver driver, WebElement element) {
        boolean elemento=true;
        try {WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
            wait.until((ExpectedCondition<Boolean>) drive -> element.isEnabled());
        } catch (Exception e) {
            System.out.println("No se encontro el elemento");
            elemento = false;
        }
        return elemento;
    }

    public static void waitAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Texto de la alerta:" + alert.getText());
    }

    public static void clicActions(WebDriver driver, String element) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        actions.click(element1).perform();
    }

    public static void scrollToElement(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        js.executeScript("arguments[0].scrollIntoView(true);", element1);
    }

    public static void scrollToElement2(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clicJavascript(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        js.executeScript("arguments[0].click();", element1);
    }

    public static void scrollDown(WebDriver driver, String numDown) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + numDown + ")", "");
    }

    public static void scrollTopPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);", "");
    }

    public static void scrollToEnd(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
    }

    public static void clicElementwithScroll(WebDriver driver, String elementXpath) {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        Point point = element.getLocation();
        int xcord = point.getX() + 5;
        int ycord = point.getY() + 5;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("el = document.elementFromPoint(" + xcord + ", " + ycord + "); el.click();");
        }
//        new Actions(driver).moveByOffset(xcord, ycord).click().build().perform();
//        executor.executeScript("arguments[0].click();", element);
    }

    public static void explicitWait(WebDriver driver, WebElement dateFechaIni) {
    }

    public void clicPerform(WebDriver driver, String element) {

    }

    public static void waitDataIsNotVisibleInput(WebDriver driver, String element) {
        boolean loop = false;
        do {
            Util.explicitWait(4);
            List<WebElement> modalErrorCot = driver.findElements(By.xpath(element));
            int countElement = modalErrorCot.size();
            if (countElement < 1) {
                loop = true;
            }
        } while (loop != true);
    }

    public static void pageStatus(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    public static WebElement switchTo(WebDriver driver) {
        try {
            WebElement currentElement = driver.switchTo().activeElement();
            return driver.switchTo().activeElement();
//            driver.switchTo().frame(driver.findElement(By.xpath(locator)));
        } catch (NoSuchFrameException e) {
            return null;
        }
    }

    public static void switchToWindow(WebDriver driver) {
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
//        String parentWindowContact = driver.getWindowHandle();
        String childWindowId = it.next();
        System.out.println(set);
        driver.switchTo().window(childWindowId);
    }

    public static WebDriver windowByTitle(WebDriver driver, String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (title.contains(driver.getTitle())) {
                return driver;
            }
        }
        throw new NoSuchWindowException("Window with title not found: " + title);
    }

    public static void isVisibleAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert1.getText());
            String name = alert1.getText();
            Alert alert = driver.switchTo().alert();
            if (name.contains("could not be loaded")) {
                alert.accept();
            } else {
                System.out.println("No apareció la alerta");
            }
        } catch (Throwable e) {
            System.out.println("No apareció la alerta");
        }
    }

    public static void isVisibleAlertTemporal(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert1.getText());
            String name = alert1.getText();
            Alert alert = driver.switchTo().alert();
            if (name.contains(text)) {
                alert.accept();
            } else {
                System.out.println("No apareció la alerta");
            }
        } catch (Throwable e) {
            System.out.println("No apareció la alerta");
        }
    }

    public static void ifNotVisibleAlertAndClick(WebDriver driver, String text, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert1.getText());
            String name = alert1.getText();
            Alert alert = driver.switchTo().alert();
            if (name.contains(text)) {
                alert.accept();
            } else {
                Actions actions = new Actions(driver);
                actions.click(element).build().perform();
                wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
            }
        } catch (Throwable e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);
            actions.click(element).build().perform();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public static void isVisibleAlertTemporalOr(WebDriver driver, String text, String text2) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert1.getText());
            String name = alert1.getText();
            Alert alert = driver.switchTo().alert();
            if (name.contains(text) || name.contains(text2)) {
                alert.accept();
            } else {
                System.out.println("No apareció la alerta");
            }
        } catch (Throwable e) {
            System.out.println("No apareció la alerta");
        }
    }

    public static void isVisibleAlertRFCValidation(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert1.getText());
            String name = alert1.getText();
            Alert alert = driver.switchTo().alert();
            if (name.contains(text)) {
                alert.accept();
            } else {
                System.out.println("No apareció la alerta");
            }
        } catch (Throwable e) {
            System.out.println("No apareció la alerta");
        }
    }

    public static void isVisibleAlertRFC(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert.getText());
            String name = alert.getText();
            if (name.contains(text)) {
                alert.accept();
                WebElement btnAceptar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAceptarGen")));
                btnAceptar.click();
            } else {
                System.out.println("No apareció la alerta");
            }
        } catch (Throwable e) {
            System.out.println("No apareció la alerta");
        }
    }

    public static void findExplicitElement(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public static void cambiarVentana(WebDriver driver, int pantalla) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(pantalla));
        } catch (Exception e) {

        }
    }
    public static void ifNotVisibleAlert(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert1.getText());
            String name = alert1.getText();
            Alert alert = driver.switchTo().alert();
            if (name.contains(text)) {
                alert.accept();
            } else {
                System.out.println("No se encontró ninguna alerta selenium");
                alert.accept();
            }
        } catch (Throwable e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public static void isVisibleAlertError(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de la alerta:" + alert1.getText());
            String name = alert1.getText();
            if (name.contains(text)) {
                throw new Exception("Something bad happened.");
            }
        } catch (Throwable e) {
            System.out.println("No apareció la alerta");
        }
    }

    public static void waitElementNoVisible(WebDriver driver, String element) {
        boolean loop = false;
        do {
            Util.explicitWait(2);
            List<WebElement> elementVisible = driver.findElements(By.xpath(element));
            int elementVisible1 = elementVisible.size();
            int countAddH = 30;
            for (int i = 1; i <= countAddH; i++) {
                if ((i == countAddH)) {
                    loop = true;
                    break;
                }
            }
            if (elementVisible1 < 1) {
                loop = true;
            }
        } while (loop != true);
    }

    public static void waitElementItsNotVisible(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(15));

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
            // Si el elemento se vuelve invisible antes de 5 minutos, el método continuará.
        } catch (Exception e) {
            // Si el elemento sigue visible después del tiempo de espera, capturamos la excepción.
            System.out.println("El elemento sigue visible después 15 minutos de espera: " + e.getMessage());
        }
    }


    public static void waitElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebDriverWait wait(WebDriver driver) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundEsp));
        return wait;
    }

    public static void ingresarFechaActual(WebDriver driver, String xpathField, String dateFormat) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern(dateFormat));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathField)));
            dateField.clear();
            dateField.sendKeys(formattedDate);
        } catch (TimeoutException e) {
            throw new RuntimeException("El campo para ingresar la fecha no fue encontrado: " + xpathField, e);
        }
    }

    public static void ingresarFechaConAnioSiguiente(WebDriver driver, String xpathField, String formatoFecha) {
        LocalDate fechaActual = LocalDate.now().plusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
        String fechaConAnioSiguiente = fechaActual.format(formatter);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campoFecha = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathField)));
        campoFecha.clear();
        campoFecha.sendKeys(fechaConAnioSiguiente);
    }

    public static String generarRFCAleatorio() {
        Random random = new Random();
        String letras = generarLetrasAleatorias(4);
        String fecha = generarFechaAleatoria();
        String homoclave = generarHomoclave();
        return letras + fecha + homoclave;
    }

    public static String generarRFCPersonaMoralconAmperson(String razonsocial,String fecha) {
        Random random = new Random();

        String letras = generarLetrasPersonaMoralConAmperson(razonsocial);
        String fechaformato = String.valueOf(generarFechaRFC(fecha));
        String homoclave = generarHomoclave();
        return letras + fechaformato + homoclave;
    }

    public static String generarRFCPersonaMoral(String razonsocial,String fecha) {
        Random random = new Random();
        String letras = generarLetrasPersonaMoral(razonsocial);
        String fechaformato = String.valueOf(generarFechaRFC(fecha));
        String homoclave = generarHomoclave();
        return letras + fechaformato + homoclave;
    }

    private static String generarLetrasAleatorias(int cantidad) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder letras = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int index = random.nextInt(caracteres.length());
            letras.append(caracteres.charAt(index));
        }
        return letras.toString();
    }

    private static String generarLetrasPersonaMoralConAmperson(String razonsocial) {
        char primerletra = razonsocial.charAt(0);
        int contador=0;
        String letras = String.valueOf(primerletra);

        for (int i = 0; i < razonsocial.length(); i++) {
            if(razonsocial.charAt(i)=='&'){
                letras=letras+"&";
                contador = i+1;
        }
        }

        for (; contador < razonsocial.length(); contador++) {
            if((razonsocial.charAt(contador)!=' ')){
                letras=letras+razonsocial.charAt(contador);
                break;
            }
        }
        System.out.println("Letras:"+letras);

        return letras;
    }

    private static String generarLetrasPersonaMoral(String razonsocial) {
        String letras="";

        for(int i=0;i<3;i++){
            letras=letras+razonsocial.charAt(i);
        }
        return letras;
    }

    public static String generarFechaAleatoria() {
        Random random = new Random();
        int anio = 1950 + random.nextInt(74);
        int mes = 1 + random.nextInt(12);
        int dia = 1 + random.nextInt(28);
        return String.format("%02d%02d%02d", anio % 100, mes, dia);
    }
    public static String generarFechaAleatoria2() {
        Random random = new Random();
        int anio = 1950 + random.nextInt(74);
        int mes = 1 + random.nextInt(12);
        int dia = 1 + random.nextInt(28);
        return String.format("%02d%02d%04d", anio % 100, mes, dia);
    }

    public static String generarRFCAleatorioConAmpersand() {
        Random random = new Random();
        String letras = generarLetrasAleatoriasConAmpersand(4); // Genera 4 caracteres incluyendo el '&'
        String fecha = generarFechaAleatoria(); // Genera fecha en formato YYMMDD
        String homoclave = generarHomoclave(); // Genera homoclave
        return letras + fecha + homoclave;
    }

    private static String generarLetrasAleatoriasConAmpersand(int cantidad) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder letras = new StringBuilder();
        Random random = new Random();
        int posicionAmpersand = random.nextInt(cantidad - 1);
        for (int i = 0; i < cantidad; i++) {
            if (i == posicionAmpersand) {
                letras.append('&');
            } else {
                int index = random.nextInt(caracteres.length());
                letras.append(caracteres.charAt(index));
            }
        }
        return letras.toString();
    }

    private static StringBuilder generarFechaRFC(String fecha) {

        String fechaformato="";
        String anio="";
        String mes="";
        String dia="";

        anio = anio+fecha.charAt(8);
        anio = anio+fecha.charAt(9);

        mes = mes+fecha.charAt(3);
        mes = mes+fecha.charAt(4);

        dia = dia+fecha.charAt(0);
        dia = dia+fecha.charAt(1);

        fechaformato=anio+mes+dia;

        System.out.println("Fechar formato :"+fechaformato);

        // Formatear como aaMMDD
        return new StringBuilder(fechaformato);
    }

    private static String generarHomoclave() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numero = "0123456789";
        StringBuffer homoclave = new StringBuffer();
        StringBuffer numLast = new StringBuffer();
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(caracteres.length());
            homoclave.append(caracteres.charAt(index));
        }
        for (int i = 0; i < 1; i++) {
            int index = random.nextInt(numero.length());
            numLast.append(numero.charAt(index));
        }
        String letras = homoclave.toString();
        String numero2 = numLast.toString();
        return letras + numero2;
    }

    public static boolean isElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void waitSpinner(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[@class='spinner-label ng-binding']")));
            System.out.println("El spinner desapareció.");
        } catch (Exception e) {
            throw new RuntimeException("El spinner no desapareció después de " + timeoutInSeconds + " segundos.", e);
        }
    }

    public static void desactivarIframe(WebDriver driver) {
        try {
            driver.switchTo().defaultContent();
            System.out.println("Iframe desactivado. Contexto principal activado.");
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al intentar desactivar el iframe. Detalles: " + e.getMessage(), e);
        }
    }

    public static void activarIframe(WebDriver driver, String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            driver.switchTo().frame(iframeElement);
            System.out.println("Se activó el iframe correctamente.");
        } catch (NoSuchElementException e) {
            System.err.println("No se encontró el iframe con el xpath especificado: " + xpath);
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("El iframe no apareció dentro del tiempo de espera: " + xpath);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Ocurrió un error al intentar activar el iframe.");
            e.printStackTrace();
        }
    }

    public static String generarnumerosaletorios() {
        //Genera número aleatorio entre 10mil a un 100mil
        Random random = new Random();

        // Generar un número aleatorio entre 10000 y 100000
        int numeroAleatorio = 1000 + random.nextInt(100000 - 10000 + 1);

        System.out.println("Número aleatorio: " + numeroAleatorio);

        return String.valueOf(numeroAleatorio);
    }

    public static String generarDireccionLarga() {
        String[] calles = {"Avenida Central", "Calle del Sol", "Boulevard de la Luna", "Carretera Nacional", "Paseo de los Jardines"};
        String[] ciudades = {"Ciudad de México", "Guadalajara", "Monterrey", "Puebla", "Querétaro"};
        String[] estados = {"Estado de México", "Jalisco", "Nuevo León", "Puebla", "Querétaro"};
        Random random = new Random();
        String calle = calles[random.nextInt(calles.length)];
        int numero = random.nextInt(9999) + 1;
        String ciudad = ciudades[random.nextInt(ciudades.length)];
        String estado = estados[random.nextInt(estados.length)];
        String codigoPostal = String.format("%05d", random.nextInt(100000));
        String direccionLarga = calle + " " + numero + ", Colonia Centro, " + ciudad + ", " + estado + ", C.P. " + codigoPostal;
        while (direccionLarga.length() <= 80) {
            direccionLarga += " - Extensión " + random.nextInt(100);
        }
        return direccionLarga;
    }

    public static void limpiarCampo(WebElement campo, String xpath) {
        campo.clear();
        if (xpath != null && !xpath.isEmpty()) {
            campo.sendKeys(xpath);
        }
    }
    public static void runRfcAleatorio(String nombreRfcVariable) {
        // Los caracteres de interés en un array de char.
        char[] chars = "0123456789".toCharArray();
        char[] charsCar = "ERTYUPASDFGHJKLCVBNM".toCharArray();
        int charsLength = chars.length;
        int charsLengthCar = charsCar.length;
        // Instanciamos la clase Random
        Random random = new Random();
        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i = 0; i < 4; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer.append(charsCar[random.nextInt(charsLengthCar)]);
        }
        for (int i = 0; i < 2; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer2.append(charsCar[random.nextInt(charsLengthCar)]);
        }
        // Y solo nos queda hacer algo con la cadena
        String letras4 = buffer.toString();
        String letras2 = buffer2.toString();
        int mes = ThreadLocalRandom.current().nextInt(10, 12 + 1);
        int dia = ThreadLocalRandom.current().nextInt(10, 30 + 1);
        int numero1 = ThreadLocalRandom.current().nextInt(1980, 2005 + 1);
        int numero2 = ThreadLocalRandom.current().nextInt(1, 9 + 1);
        String anio1 = String.valueOf(numero1);
        String anio2 = anio1.substring(2, 4);
        String mes1 = String.valueOf(mes);
        String dia1 = String.valueOf(dia);
        String lastNumber = String.valueOf(numero2);
        String rfc = letras4 + anio2 + mes1 + dia1 + letras2 + lastNumber;
        ExcelData.writeJsonGlobal(nombreRfcVariable, rfc);
    }
}
