package tests.game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.game.RandomSelectEnemy;

public class RandomSelectEnemyTest {
    private RandomSelectEnemy<String> randomSelectEnemy;
    private String[] allOptions = new String[] { "Option1", "Option2", "Option3" };

    public RandomSelectEnemyTest() {
        randomSelectEnemy = new RandomSelectEnemy<String>(allOptions);
    }

    @Test
    void testSelectOption() {
        for (int i = 0; i < 100; i++) {
            String selectedOption = randomSelectEnemy.selectOption();
            assertTrue(Arrays.stream(allOptions).anyMatch(x -> x == selectedOption));
        }
    }

    @Test
    void testSelectOptionLimited() {
        String[] arrowSelectValues = new String[] { "Option1", "Option2" };
        for (int i = 0; i < 100; i++) {
            String selectedOption = randomSelectEnemy.selectOptionLimited(arrowSelectValues);
            assertTrue(Arrays.stream(arrowSelectValues).anyMatch(x -> x == selectedOption));
        }
    }

    @Test
    void testSelectOptionLimited2() {
        int[] arrowSelectIndexes = new int[] { 0, 2 };
        for (int i = 0; i < 100; i++) {
            String selectedOption = randomSelectEnemy.selectOptionLimited(arrowSelectIndexes);
            assertTrue(selectedOption == allOptions[0] || selectedOption == allOptions[2]);
        }
    }
}
