package tests.game;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.game.BattleResult;
import main.game.GameResultRecoder;

public class GameResultRecoderTest {

    private GameResultRecoder gameResultRecoder;

    @Test
    public void testRecordCountUpWhenRegistResult() {
        gameResultRecoder = new GameResultRecoder("TestGameName1");
        gameResultRecoder.recordResult(BattleResult.Win);
        assertEquals(gameResultRecoder.getRecordCount(BattleResult.Win), 1);
        gameResultRecoder.recordResult(BattleResult.Win);
        assertEquals(gameResultRecoder.getRecordCount(BattleResult.Win), 2);
    }

    @Test
    public void testDefaultCountZeroAndSeparateWithName() {
        gameResultRecoder = new GameResultRecoder("TestGameName2");
        GameResultRecoder anotherGameResultRecoder = new GameResultRecoder("AnotherTestGameName");
        gameResultRecoder.recordResult(BattleResult.Win);
        gameResultRecoder.recordResult(BattleResult.Lose);
        gameResultRecoder.recordResult(BattleResult.Draw);
        assertEquals(anotherGameResultRecoder.getRecordCount(BattleResult.Win), 0);
        assertEquals(anotherGameResultRecoder.getRecordCount(BattleResult.Lose), 0);
        assertEquals(anotherGameResultRecoder.getRecordCount(BattleResult.Draw), 0);
    }

    @Test
    // セーブした後だと、同じ名前でインスタンスを作っても前回の記録が残っていることを確認するテスト
    public void testFetchRecordCountAfterSave() {
        gameResultRecoder = new GameResultRecoder("TestGameName3");
        gameResultRecoder.recordResult(BattleResult.Win);
        gameResultRecoder.saveRecord();
        GameResultRecoder sameNameGareRecoder = new GameResultRecoder("TestGameName3");
        assertEquals(sameNameGareRecoder.getRecordCount(BattleResult.Win), 1);
    }
}
