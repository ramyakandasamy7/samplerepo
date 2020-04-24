import java.io.FileReader;

public interface FileReaderStrategy {
     ISOCardFactory cardFactory = new ISOCardFactory();
     void getOutput(String inputfilename, String outputfilename);
}
