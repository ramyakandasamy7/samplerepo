import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;
import junitx.framework.FileAssert;

import static org.junit.jupiter.api.Assertions.*;

class JSONFileStrategyTest {
    JSONFileStrategy test = new JSONFileStrategy();

    @org.junit.jupiter.api.Test
    void getTest() throws IOException {
        test.getOutput("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/InputFile.json", "/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/TestOutputFile.json");
        File file1 = new File("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/ExpectedOutput.json");
        File file2 = new File("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/TestOutputFile.json");
        FileAssert.assertEquals(file1, file2);
    }

}