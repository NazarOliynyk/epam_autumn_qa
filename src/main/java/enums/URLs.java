package enums;

public enum URLs {

    MAIN_URL("https://training.by"),
    HOME_PAGE_URL("https://training.by/#/Home");

    public String getValue() {

        return value;
    }

    String value;
    URLs(String value){

        this.value = value;
    }
}