package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import otus_java_basic.Marchenko.ProjectWork.ConsoleUserInteractionService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class testOutputToConsole {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testString() {
        String value = "сорок пять ";
        String currency = "рублей";
        String outputStrTest = value + currency;

        ConsoleUserInteractionService example = new ConsoleUserInteractionService();
        example.outputToConsole(value, currency);
        Assert.assertEquals(outputStrTest, output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
