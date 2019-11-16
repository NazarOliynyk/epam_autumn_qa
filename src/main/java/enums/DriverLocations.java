package enums;

public enum DriverLocations {

    CHROME_DRIVER_LOCATION("src/main/resources/chromedriver.exe"),
    FIREFOX_DRIVER_LOCATION("src/main/resources/chromedriver.exe");

    public String getValue() {

        return value;
    }

    String value;
    DriverLocations(String value){

        this.value = value;
    }
}
