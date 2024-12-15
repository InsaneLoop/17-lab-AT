
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;

public class JMeterRunner {
    public static void main(String[] args) throws Exception {
        // Initialize JMeter engine
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // JMeter initialization (replace with your JMeter path)
        JMeterUtils.setJMeterHome("path_to_jmeter"); // Replace with actual JMeter path
        JMeterUtils.loadJMeterProperties("path_to_jmeter/bin/jmeter.properties");

        // Load existing .jmx Test Plan
        SaveService.loadProperties();
        File testPlan = new File("src/main/resources/mantis_test_plan.jmx");
        HashTree testPlanTree = SaveService.loadTree(testPlan);

        // Run JMeter Test Plan
        jmeter.configure(testPlanTree);
        jmeter.run();
    }
}
