package tests.game;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.console.Selector;
import main.console.SelectorOutputTester;
import main.game.Option;
import main.game.PlayerHandSelector;

public class PlayerHandSelectorTest {
    private PlayerHandSelector<String> playerHandSelector;
    private List<Option<String>> options;
    Selector<String> selector;
    SelectorOutputTester outputTester;

    public PlayerHandSelectorTest() {
        options = new ArrayList<Option<String>>();
        outputTester = new SelectorOutputTester();
        options.add(new Option<String>(1, "Option1", "Option1"));
        options.add(new Option<String>(2, "Option2", "Option2"));
        options.add(new Option<String>(3, "Option3", "Option3"));
        selector = new Selector<>(options, outputTester);
        playerHandSelector = new PlayerHandSelector<String>(options, selector, outputTester);
    }

    @Test
    void testSelectOption() {
        setDownArrayInput();
        assertEquals(playerHandSelector.selectOption(), "Option2");
    }

    private void setUpArrayInput() {
        outputTester.addInputKeyCodes(27, 79, 65);
    }

    private void setDownArrayInput() {
        outputTester.addInputKeyCodes(27, 79, 66);
    }

    private void setIntegerInput(int input) {
        outputTester.addInputKeyCodes(48 + input);
    }

    @Test
    void testSelectOptionLimited() {
        setIntegerInput(2);
        assertEquals(playerHandSelector.selectOption(), "Option2");
    }

    @Test
    void testSelectOptionLimited2() {

    }
}
