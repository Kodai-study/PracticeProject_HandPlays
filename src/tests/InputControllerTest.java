package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;

import main.console.ArrayKeys;
import main.console.InputController;
import main.console.InputType;

public class InputControllerTest {
    private InputController inputContext;

    public InputControllerTest() {
        inputContext = new InputController();
    }

    @Test
    public void testInputNumbersZero() {
        inputContext.regist_input(48);
        assert inputContext.get_input_type().equals(main.console.InputType.Number);
        assert inputContext.get_number_input() == 0;

    }

    @Test
    public void testInputNumbersNine() {
        inputContext.regist_input(57);
        assert inputContext.get_input_type().equals(main.console.InputType.Number);
        assert inputContext.get_number_input() == 9;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 10; i <= 40; i++) {
            data.add(new Object[] { i });
        }
        return data;
    }

    @Test
    public void testInputLowerCharKey() {
        int minCharCode = (int) 'a';
        int maxCharCode = (int) 'z';
        inputContext.regist_input(minCharCode);
        assertEquals(inputContext.get_input_type(), InputType.Char);
        inputContext.regist_input(maxCharCode);
        assertEquals(inputContext.get_input_type(), InputType.Char);
    }

    @Test
    public void testInputUpperCharKey() {
        int minCharCode = (int) 'A';
        int maxCharCode = (int) 'Z';
        inputContext.regist_input(minCharCode);
        assertEquals(inputContext.get_input_type(), InputType.Char);
        inputContext.regist_input(maxCharCode);
        assertEquals(inputContext.get_input_type(), InputType.Char);
    }

    @Test
    public void testArrayKeysInput() {
        int[][] testData = {
                { 27, 79, 65 }, // ARROW_UP27 79 65
                { 27, 79, 66 }, // ARROW_DOWN
                { 27, 79, 67 }, // ARROW_RIGHT
                { 27, 79, 68 } // ARROW_LEFT
        };

        ArrayKeys[] expectedResults = {
                ArrayKeys.Up,
                ArrayKeys.Down,
                ArrayKeys.Right,
                ArrayKeys.Left
        };

        for (int i = 0; i < testData.length; i++) {
            for (int keyCode : testData[i]) {
                inputContext.regist_input(keyCode);
            }
            assert inputContext.get_input_type().equals(main.console.InputType.ArrayKey);
            assert inputContext.get_array_input_key().equals(expectedResults[i]);
        }
    }
}
