import junitx.framework.FileAssert;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class XMLFileStrategyTest {
    XMLFileStrategy test = new XMLFileStrategy();
    @Test
    void getTest() {
        test.getOutput("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/InputFile.xml", "/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/TestOutputFile.xml");
        File file1 = new File("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/ExpectedOutput.xml");
        File file2 = new File("/Users/ramyakandasamy/IdeaProjects/creditCardFileReader/TestOutputFile.xml");
        FileAssert.assertEquals(file1, file2);
    }
}