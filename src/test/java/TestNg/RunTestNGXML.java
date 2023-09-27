package TestNg;

import com.beust.jcommander.internal.Lists;
import org.testng.TestNG;

import java.util.List;

public class RunTestNGXML {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("testng.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}