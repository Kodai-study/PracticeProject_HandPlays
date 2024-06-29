package main.game;

public interface IGameResultRecoder {
    public void recordResult(BattleResult result);

    public int getRecordCount(BattleResult result);

    public void saveRecord();
}
