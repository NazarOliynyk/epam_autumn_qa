package db;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DbConfiguration dbConfiguration = new DbConfiguration();
        dbConfiguration.setConfiguration();

        FAQitem [] array=
                new FAQitem[]{
                        new FAQitem("Are there any candidate specifications (age, education)?"),
                        new FAQitem("When does program registration start?"),
                        new FAQitem("How much does it cost to study at EPAM Training Center?"),
                        new FAQitem("I applied for training, but no one has contacted me yet?"),
                        new FAQitem("Is there a possibility to look through test samples?"),
                        new FAQitem("In case I fail test, will I be notified via email?"),
                        new FAQitem("I am dissatisfied with the results of the test. Can it be reviewed?"),
                        new FAQitem("Are there any candidate specifications (age, education)?"),
                        new FAQitem("I am not sure that the level of my knowledge is sufficient. Can I still apply for training?"),
                        new FAQitem("Can I apply for various directions and programs?"),
                        new FAQitem("Is there a possibility of getting a position at EPAM having studied at the Training Center?")
                };

        List<FAQitem> list = Arrays.asList(array);
        list.forEach(dbConfiguration::save);

        dbConfiguration.quitConfiguration();
    }
}
