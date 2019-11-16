package enums;

public enum Drivers {

    CHROME_DRIVER("webdriver.chrome.driver"),
    FIREFOX_DRIVER("");

    public String getValue() {

        return value;
    }

    String value;
    Drivers(String value){

        this.value = value;
    }
}
