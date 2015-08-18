package test;

import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import playground.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestCasesExample {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void before() {

    }

    @Test
    public void testExample() {
        System.out.println("Hello World.");
        Assert.assertThat(outputCapture.toString(), Matchers.containsString("Hello"));
    }

    @After
    public void after() {

    }

    @AfterClass
    public static void afterClass() {

    }
}
