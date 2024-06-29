package main.console;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.game.Option;

public class SelectorTest {
    List<Option<String>> options;
    SelectorOutputTester terminalManager;
    Selector<String> selector;

    public SelectorTest() {
        options = new ArrayList<Option<String>>();

        options.add(new Option<String>(1, "Option1", "Option1"));
        options.add(new Option<String>(2, "Option2", "Option2"));
        options.add(new Option<String>(3, "Option3", "Option3"));
        terminalManager = new SelectorOutputTester();

        this.selector = new Selector<>(options, terminalManager);
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
        for (int i = 0; i < options.size(); i++) {
            selector.selectDown();
        }
        String[] output = terminalManager.getOutput();
        assertEquals(output[0], " > Option1");
        assertEquals(output[1], "   Option2");
        assertEquals(output[2], "   Option3");
        assertEquals(selector.getSelectedIndex(), 0);
    }

}
