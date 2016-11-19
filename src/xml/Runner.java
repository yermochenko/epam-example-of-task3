package xml;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        VaucherXmlValidator validator = new VaucherXmlValidator("vauchers.xml");
        if (validator.validate()) {
            System.out.println("OK");
        } else {
            System.out.println(validator.getError());
        }
    }
}