package main.console;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SelectorTest {
    String[] options;
    SelectorOutputTester terminalManager;
    Selector selector;

    public SelectorTest() {
        options = new String[] { "Option1", "Option2", "Option3" };
        terminalManager = new SelectorOutputTester();
        selector = new Selector(options, terminalManager);
    }

    @Test
    public void testViewAllOptions() {
        selector.viewOptions();
        String[] output = terminalManager.getOutput();
        assertEquals(output[0], " > Option1");
        assertEquals(output[1], "   Option2");
        assertEquals(output[2], "   Option3");
        assertEquals(selector.getSelectedIndex(), 0);
    }

    @Test
    public void testSelectDown() {
        selector.selectDown();
        String[] output = terminalManager.getOutput();
        assertEquals(output[0], "   Option1");
        assertEquals(output[1], " > Option2");
        assertEquals(output[2], "   Option3");
        assertEquals(selector.getSelectedIndex(), 1);
    }

    @Test
    public void testSelectUp() {
        selector.selectUp();
        String[] output = terminalManager.getOutput();
        assertEquals(output[0], "   Option1");
        assertEquals(output[1], "   Option2");
        assertEquals(output[2], " > Option3");
        assertEquals(selector.getSelectedIndex(), 2);
    }

    @Test
    public void testSelectUpAfterDown() {
        selector.selectDown();
        selector.selectDown();
        selector.selectUp();
        String[] output = terminalManager.getOutput();
        assertEquals(output[0], "   Option1");
        assertEquals(output[1], " > Option2");
        assertEquals(output[2], "   Option3");
        assertEquals(selector.getSelectedIndex(), 1);
    }

    @Test
    public void testSelectUpOverOptionNumbers() {
        for (int i = 0; i < options.length; i++) {
            selector.selectDown();
        }
        String[] output = terminalManager.getOutput();
        assertEquals(output[0], " > Option1");
        assertEquals(output[1], "   Option2");
        assertEquals(output[2], "   Option3");
        assertEquals(selector.getSelectedIndex(), 0);
    }

}
