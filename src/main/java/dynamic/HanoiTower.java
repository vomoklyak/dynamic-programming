package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HanoiTower {

    public static void move(int numberOfDiscs) {
        move(1, 2, numberOfDiscs);
    }

    private static void move(int formPegIndex, int toPegIndex, int numberOfDiscs) {
        if (numberOfDiscs == 1) {
            log.info("Move disc-{} from {} to {}", numberOfDiscs, formPegIndex, toPegIndex);
        } else {
            int tempPegIndex = 6 - formPegIndex - toPegIndex;
            move(formPegIndex, tempPegIndex, numberOfDiscs - 1);
            log.info("Move disc-{} from {} to {}", numberOfDiscs, formPegIndex, toPegIndex);
            move(tempPegIndex, toPegIndex, numberOfDiscs - 1);
        }
    }

}