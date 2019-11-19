package sources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileHandler {

    private static String email;
    private static String password;
    private static String login;

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getLogin() {
        return login;
    }

    public  void getProps(){
        try (InputStream input =
                     new FileInputStream("src\\main\\resources\\config.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            email = prop.getProperty("email");

            password = prop.getProperty("password");

            login = prop.getProperty("login");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PropertyFileHandler().getProps();
    }
}
