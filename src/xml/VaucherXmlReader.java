package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import domain.Food;
import domain.IsTV;
import domain.StarsCount;
import domain.TransportType;
import domain.Vaucher;

public class VaucherXmlReader {
    public List<Vaucher> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Vaucher> vauchers = new ArrayList<Vaucher>();
            Vaucher vaucher = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("vaucher".equals(tagName)) {
                        vaucher = new Vaucher();
                        vaucher.setIdentity(reader.getAttributeValue(null, "id"));
                    } else if ("type".equals(tagName)) {
                        vaucher.setType(reader.getElementText());
                    } else if ("country".equals(tagName)) {
                        vaucher.setCountry(reader.getElementText());
                    } else if ("days".equals(tagName)) {
                        String deltaNights = reader.getAttributeValue(null, "nights");
                        vaucher.setDeltaNights(deltaNights != null ? Integer.parseInt(deltaNights) : 0);
                        vaucher.setDays(Integer.parseInt(reader.getElementText()));
                    } else if ("transport".equals(tagName)) {
                        vaucher.setTransportType(TransportType.valueOf(reader.getElementText()));
                    } else if ("cost".equals(tagName)) {
                        vaucher.setCost(Long.parseLong(reader.getElementText()));
                    } else if ("stars".equals(tagName)) {
                        StarsCount stars = new StarsCount();
                        stars.setElement(tagName);
                        stars.setValue(reader.getElementText());
                        vaucher.getCharacteristics().add(stars);
                    } else if ("tv".equals(tagName)) {
                        IsTV tv = new IsTV();
                        tv.setElement(tagName);
                        tv.setValue(reader.getElementText());
                        vaucher.getCharacteristics().add(tv);
                    } else if ("food".equals(tagName)) {
                        Food food = new Food();
                        food.setElement(tagName);
                        food.setValue(reader.getElementText());
                        vaucher.getCharacteristics().add(food);
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("vaucher".equals(tagName)) {
                        vauchers.add(vaucher);
                    }
                    break;
                }
                }
            }
            return vauchers;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}