import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CSVFileStrategy implements FileReaderStrategy {

    public void getOutput(String inputPath, String outputPath) {
        try {
       BufferedReader csvReader = new BufferedReader((new FileReader(inputPath)));
        FileWriter csvWriter = new FileWriter(outputPath);
        csvWriter.append("CardNumber");
        csvWriter.append(",");
        csvWriter.append("CardType");
        csvWriter.append(",");
        csvWriter.append("Error");
        csvWriter.append("\n");
       //skip first line
       csvReader.readLine();
       String row = csvReader.readLine();
        while (row !=null) {
            String[] temp = row.split(",");
            SimpleDateFormat sdfAmerica = new SimpleDateFormat("MM/dd/yyyy");
            Date date1=sdfAmerica.parse(temp[1]);
            if (cardFactory.getCard(temp[0]) == null) {
                csvWriter.append(temp[0]+","+"Invalid,InvalidCardNumber");
            }
            else {
                if (date1.compareTo(new Date()) < 0)
                {
                    csvWriter.append(temp[0] + "," + cardFactory.getCard(temp[0]).returnName()+","+"InvalidExpirationDate"+"\n");
                }
                else {
                    csvWriter.append(temp[0] + "," + cardFactory.getCard(temp[0]).returnName() + "," + "None" + "\n");
                }
            }
            row = csvReader.readLine();
        }
        csvReader.close();
        csvWriter.close();
        }
    catch (Exception e) {

    }
   /* public static void main(String args[]) {
        CSVFileReader x = new CSVFileReader();
        try {
            x.getOutput();
        }
        catch (IOException e) {
            System.out.print(e);
        }
        catch (ParseException e) {
            System.out.println(e);
        }

    }*/

}
}


