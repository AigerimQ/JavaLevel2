package lesson1.obstacles;

import lesson1.participants.Member;

public class Wall implements Obstacles{
    private final int height;

    public Wall(int height) {
        this.height = height;
    }
    @Override
    public boolean passing(Member member) {
        int jumpHeight = member.jump();
        if(jumpHeight >= height){
            System.out.printf("Участник успешно перепрыгнул стену высотой %d м.\n", height);
            return true;
        } else {
            System.out.printf("Участник не смог перепрыгнуть стену высотой %d м.\n", height);
            return false;
        }
    }
}
