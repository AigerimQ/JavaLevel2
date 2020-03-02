package lesson1;

import lesson1.obstacles.Obstacles;
import lesson1.obstacles.RunningTrack;
import lesson1.obstacles.Wall;
import lesson1.participants.Cat;
import lesson1.participants.Human;
import lesson1.participants.Member;
import lesson1.participants.Robot;

public class Lesson1 {
    public static void main(String[] args) {
        Member human = new Human("Aika", 1, 500);
        Member cat = new Cat("Murzik", 1, 300);
        Member robot = new Robot("BD-1", 2, 0);

        RunningTrack runningTrack = new RunningTrack(200);
        Wall wall = new Wall(1);
//        System.out.println(runningTrack.passing(human));
//        System.out.println(wall.passing(human));
        Member[] members = {human, cat, robot};

        passingObstacles(wall, members);
        passingObstacles(runningTrack, members);

    }


    private static void passingObstacles(Obstacles obstacles, Member... members) {
        for (Member member : members) {
//            System.out.println(member);
            System.out.println(obstacles.passing(member));
        }
    }


}
