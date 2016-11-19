package xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import domain.Vaucher;

public class VaucherXmlWriter {
    public void write(List<Vaucher> vauchers, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("vauchers");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/vauchers");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/vauchers vauchers.xsd");
            for (Vaucher vaucher : vauchers) {
                writer.writeStartElement("vaucher");
                writer.writeAttribute("id", vaucher.getIdentity());
                writer.writeStartElement("type");
                writer.writeCData(vaucher.getType());
                writer.writeEndElement();
                writer.writeStartElement("country");
                writer.writeCharacters(vaucher.getCountry());
                writer.writeEndElement();
                writer.writeStartElement("days");
                writer.writeAttribute("nights", vaucher.getDeltaNights().toString());
                writer.writeCharacters(vaucher.getDays().toString());
                writer.writeEndElement();
                writer.writeStartElement("transport");
                writer.writeCharacters(vaucher.getTransportType().toString());
                writer.writeEndElement();
                writer.writeStartElement("cost");
                writer.writeCharacters(vaucher.getCost().toString());
                writer.writeEndElement();
                writer.writeStartElement("hotel-characteristics");
                if(vaucher.getHotelCharacteristic().getStarsCount() != null) {
                    writer.writeStartElement("stars");
                    writer.writeCharacters(vaucher.getHotelCharacteristic().getStarsCount().toString());
                    writer.writeEndElement();
                }
                writer.writeStartElement("tv");
                writer.writeCharacters(Boolean.toString(vaucher.getHotelCharacteristic().isTV()));
                writer.writeEndElement();
                if(vaucher.getHotelCharacteristic().getFood() != null) {
                    writer.writeStartElement("food");
                    writer.writeCharacters(vaucher.getHotelCharacteristic().getFood().toString());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}