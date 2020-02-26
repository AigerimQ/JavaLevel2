package lesson1.obstacles;

import lesson1.participants.Member;

public class RunningTrack implements Obstacles{
    private final int length;

    public RunningTrack(int length) {
        this.length = length;
    }
    @Override
    public boolean passing(Member member) {
        int runLength = member.run();
        if(runLength >= length){
            System.out.printf("Участник успешно пробежал дистанцию длиной %d м.\n", length);
            return true;
        } else {
            System.out.printf("Участник не смог пробежать дистанцию длиной %d м.\n", length);
            return false;
        }
    }

}
