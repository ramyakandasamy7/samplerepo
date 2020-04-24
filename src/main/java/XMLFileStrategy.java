import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Element;

public class XMLFileStrategy implements FileReaderStrategy {


    public void getOutput (String inputfilename, String outputfilename){

                try {

                    File fXmlFile = new File(inputfilename);
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document input = dBuilder.parse(fXmlFile);
                    input.getDocumentElement().normalize();
                    Document output = dBuilder.newDocument();
                    Element root = output.createElement("root");
                    output.appendChild(root);
                    NodeList nList = input.getElementsByTagName("row");
                    for (int temp = 0; temp < nList.getLength(); temp++) {

                        Node nNode = nList.item(temp);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) nNode;
                            String cardNumber = eElement.getElementsByTagName("CardNumber").item(0).getTextContent();
                            Element row = output.createElement("row");
                            root.appendChild(row);
                            // if card is valid number
                            if (cardFactory.getCard(cardNumber) != null) {
                                Element cardNumberOutput = output.createElement("CardNumber");
                                cardNumberOutput.appendChild(output.createTextNode(cardNumber));
                                row.appendChild(cardNumberOutput);
                                Element typeofCard = output.createElement("Type");
                                typeofCard.appendChild(output.createTextNode(cardFactory.getCard(cardNumber).returnName()));
                                row.appendChild(typeofCard);
                                //
                                String expirationdate = eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent();
                                SimpleDateFormat sdfAmerica = new SimpleDateFormat("MM/dd/yyyy");
                                Date date1 = sdfAmerica.parse(expirationdate);
                                //if date is not valid
                                if (date1.compareTo(new Date()) < 0) {
                                    Element error = output.createElement("Error");
                                    error.appendChild(output.createTextNode("InvalidExpirationDate"));
                                    row.appendChild(error);
                                } else {
                                    Element error = output.createElement("Error");
                                    error.appendChild(output.createTextNode("None"));
                                    row.appendChild(error);
                                }
                            } else {
                                Element cardNumberOutput = output.createElement("CardNumber");
                                cardNumberOutput.appendChild(output.createTextNode(cardNumber));
                                row.appendChild(cardNumberOutput);
                                Element typeofCard = output.createElement("Type");
                                typeofCard.appendChild(output.createTextNode("Invalid"));
                                row.appendChild(typeofCard);
                                Element error = output.createElement("Error");
                                error.appendChild(output.createTextNode("InvalidCardNumber"));
                                row.appendChild(error);


                            }


                        }
                    }
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource domSource = new DOMSource(output);
                    StreamResult streamResult = new StreamResult(new File(outputfilename));
                    transformer.transform(domSource, streamResult);
                    System.out.println("Done creating XML File");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        /*    public static void main(String args[]) {
                XMLFileReader x = new XMLFileReader("/Users/ramyakandasamy/Downloads/revision.xml","/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/outputXML.xml" );
                x.getOutput();
            }*/


    }


