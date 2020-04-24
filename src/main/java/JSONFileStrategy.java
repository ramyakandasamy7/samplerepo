

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JSONFileStrategy implements FileReaderStrategy
{
    public void getOutput(String inputfile, String outputfile) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(inputfile));
            JSONArray array = (JSONArray) obj;
            JSONArray output = new JSONArray();
            for (int i = 0; i < array.size(); i++) {
                Object x = array.get(i);
               String cardNumber =  ((JSONObject) x).get("CardNumber").toString();
                JSONObject outputperLine= new JSONObject();
                if (cardFactory.getCard(cardNumber) == null) {
                    outputperLine.put("CardNumber", cardNumber);
                    outputperLine.put("CardType", "Invalid");
                    outputperLine.put("Error", "InvalidCreditCardNumber");
                }
                else {
                    outputperLine.put("CardNumber", cardNumber);
                    outputperLine.put("CardType",  cardFactory.getCard(cardNumber).returnName());
                    outputperLine.put("Error", "None");

                }
                output.add(outputperLine);
            }

            FileWriter fileOutput = new FileWriter(outputfile);
            fileOutput.write(output.toJSONString());
            fileOutput.flush();

        }
        catch (Exception e) {

        }
    }
}