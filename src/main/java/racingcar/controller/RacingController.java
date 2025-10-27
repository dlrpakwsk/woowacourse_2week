package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.View;
import racingcar.domain.Car;
import java.util.List;

public class RacingController {
    public void run() {
        List<String> carNames = View.readCarNames();
        int tryCount = View.readTryCount();

        RacingGame racingGame = new RacingGame(carNames);
        View.printResultTitle();

        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            View.printRoundResult(
                    racingGame.getCars().stream()
                            .map(Car::toString)
                            .toList()
            );
        }

        List<String> winners = racingGame.findWinners();
        View.printWinners(winners);
    }
}
