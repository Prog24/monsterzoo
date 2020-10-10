import java.util.stream.IntStream;
import java.util.ArrayList;

public class Event {
  public void move(Player player) {
    player.walk();
    int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
    if (flg1 <= 1) {
      this.zooStation(player);
    } else if (flg1 >= 7) {
      this.encountMonster(player);
    }
    this.hatchingEgg(player);
    player.nowStatus();
  }

  private ArrayList<Integer> getZooStationItem() {
    System.out.println("ズーstationを見つけた！");
    ArrayList<Integer> randomStatus = new ArrayList<Integer>();
    IntStream.range(0,3).forEach(v -> {
      randomStatus.add((int)(Math.random() * 3));
    });
    System.out.println("ボールを"+randomStatus.get(0)+"個，"+"フルーツを"+randomStatus.get(1)+"個"+"卵を"+randomStatus.get(2)+"個Getした！");
    return randomStatus;
  }

  private void zooStation(Player player) {
    ArrayList<Integer> randomStatus = this.getZooStationItem();
    player.balls.add(randomStatus.get(0));
    player.fruits.add(randomStatus.get(1));
    IntStream.range(0, randomStatus.get(2)).forEach(v -> {
        if (player.egg.count() < 10) {
          player.egg.add();
        }
      });
  }

  private void encountMonster(Player player) {
    MonsterZukan monsters = new MonsterZukan();
    Monster encountMonster = monsters.encountRandomMonster();
    System.out.println(encountMonster.name+"が現れた！");
    for (int i=0; i<3 && player.balls.count()>0; i++) {
      Integer r = (int)(6*Math.random());//0~5までの数字をランダムに返す
      r = player.fruits.throwFruits(r, player);
      player.balls.throwBall(r, player, encountMonster);
    }
  }

  private void hatchingEgg(Player player) {
    Integer tmp = player.egg.hatching();
    IntStream.range(0, tmp)
      .forEach(v -> {
        hatchingEggGetMonster(player);
      });
  }

  private void hatchingEggGetMonster(Player player) {
    MonsterZukan monsters = new MonsterZukan();
    Monster hatchingMonster = monsters.encountRandomMonster();
    System.out.println("卵が孵った！");
    System.out.println(hatchingMonster.name + "が産まれた！");
    player.monster.add(hatchingMonster.name);
  }

}
