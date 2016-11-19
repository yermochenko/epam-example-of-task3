package xml;

import java.io.IOException;
import java.util.List;

import domain.Vaucher;

public class Runner {
    public static void main(String[] args) throws IOException {
        VaucherXmlValidator validator = new VaucherXmlValidator("vauchers.xml");
        if (validator.validate()) {
            VaucherXmlReader reader = new VaucherXmlReader();
            List<Vaucher> vauchers = reader.read("vauchers.xml");
            for (Vaucher vaucher : vauchers) {
                System.out.println(vaucher);
            }
            System.out.println("OK");
        } else {
            System.out.println(validator.getError());
        }
    }
}