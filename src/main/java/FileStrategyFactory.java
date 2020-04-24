public class FileStrategyFactory {
    public FileReaderStrategy getFileStrategy (String inputfile) {
        if(inputfile.contains(".csv")) {
            return new CSVFileStrategy();
        }
        else if (inputfile.contains(".xml")) {
            return new XMLFileStrategy();
        }
        else if (inputfile.contains(".json")) {
            return new JSONFileStrategy();
        }
        else {
            return null;
        }
    }
}
