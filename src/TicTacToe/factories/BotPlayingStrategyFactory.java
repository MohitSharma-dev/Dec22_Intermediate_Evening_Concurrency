package TicTacToe.factories;

import TicTacToe.models.BotDifficultyLevel;
import TicTacToe.strategies.botStrategies.BotPlayingStrategy;
import TicTacToe.strategies.botStrategies.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategy(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
