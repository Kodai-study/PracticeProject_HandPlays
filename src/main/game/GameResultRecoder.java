package main.game;

import java.util.HashMap;
import java.util.Map;

public class GameResultRecoder implements IGameResultRecoder {

    private static Map<String, Map<BattleResult, Integer>> commonRecordMap = new HashMap<>();
    private String gameName;
    private Map<BattleResult, Integer> myGameRecordMap;

    public GameResultRecoder(String gameName) {
        this.gameName = gameName;
        if (commonRecordMap.containsKey(gameName))
            this.myGameRecordMap = commonRecordMap.get(gameName);
        else {
            myGameRecordMap = new HashMap<>();
        }
    }

    @Override
    public void recordResult(BattleResult result) {
        myGameRecordMap.put(result, myGameRecordMap.getOrDefault(result, 0) + 1);
    }

    @Override
    public int getRecordCount(BattleResult result) {
        return myGameRecordMap.getOrDefault(result, 0);
    }

    @Override
    public void saveRecord() {
        commonRecordMap.put(gameName, myGameRecordMap);
    }
}
