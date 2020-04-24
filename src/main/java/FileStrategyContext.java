import java.io.FileReader;

public class FileStrategyContext {
        private final FileStrategyFactory fileStrategyFactory = new FileStrategyFactory();
        FileReaderStrategy fileReaderStrategy;
        String inputFilePath;
        String outputFilePath;
        FileStrategyContext(String inputFilePath, String outputFilePath) {
            this.inputFilePath = inputFilePath;
            this.outputFilePath = outputFilePath;

        }

        public void createOutput() {
            fileReaderStrategy = fileStrategyFactory.getFileStrategy(inputFilePath);
            fileReaderStrategy.getOutput(inputFilePath,outputFilePath);
        }

}
