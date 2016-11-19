package xml;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.xml.stream.XMLStreamException;

import domain.Vaucher;

public class Runner {
    public static void main(String[] args) throws IOException, XMLStreamException {
        VaucherXmlValidator validator = new VaucherXmlValidator("vauchers.xml");
        if (validator.validate()) {
            VaucherXmlReader reader = new VaucherXmlReader();
            List<Vaucher> vauchers = reader.read("vauchers.xml");
            Random random = new Random();
            for (Vaucher vaucher : vauchers) {
                vaucher.setCost((long) (vaucher.getCost() * (1 + random.nextInt(100)/100.0)));
            }
            Collections.sort(vauchers);
            for (Vaucher vaucher : vauchers) {
                System.out.println(vaucher);
            }
            VaucherXmlWriter writer = new VaucherXmlWriter();
            writer.write(vauchers, "vauchers-new.xml");
            System.out.println("OK");
        } else {
            System.out.println(validator.getError());
        }
    }
}