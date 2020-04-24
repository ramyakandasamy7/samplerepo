import junitx.framework.FileAssert;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileStrategyTest {
    CSVFileStrategy test = new CSVFileStrategy();
    @Test
    void getTest() {
        test.getOutput("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/InputFile.csv", "/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/TestOutputFile.csv");
        File file1 = new File("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/ExpectedOutput.csv");
        File file2 = new File("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/TestOutputFile.csv");
        FileAssert.assertEquals(file1, file2);
    }
}