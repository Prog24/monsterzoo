import java.util.stream.IntStream;

public class Event {
  public void move(Player player) {
    player.distance.increment();
    player.egg.walk();
    int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
    if (flg1 <= 1) {
      this.zooStation(player);
    } else if (flg1 >= 7) {
      this.encountMonster(player);
    }
    this.hatchingEgg(player);
    System.out.println("手持ちのボールは"+player.balls.count()+"個，フルーツは"+player.fruits.count()+"個");
    System.out.println(player.distance.get()+"km歩いた．");
  }

  private void zooStation(Player player) {
    System.out.println("ズーstationを見つけた！");
    Integer ballStatus   = (int)(Math.random() * 3);
    Integer fruitsStatus = (int)(Math.random() * 3);
    Integer eggStatus    = (int)(Math.random() * 3);
    System.out.println("ボールを"+ballStatus+"個，"+"フルーツを"+fruitsStatus+"個"+"卵を"+eggStatus+"個Getした！");
    player.balls.add(ballStatus);
    player.fruits.add(fruitsStatus);
    IntStream.range(0, eggStatus)
      .forEach(v -> {
        if (player.egg.count() < 10) {
          player.egg.add();
        }
      });
  }

  private void encountMonster(Player player) {
    MonsterZukan monsters = new MonsterZukan();
    int m = (int)(monsters.size()*Math.random());//monsterListからランダムにモンスターを出す
    System.out.println(monsters.get(m).getName()+"が現れた！");
    for (int i=0; i<3 && player.balls.count()>0; i++) {
      int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
      if (player.fruits.count() > 0) {
        System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
        player.fruits.decrement();
        r = r * 2;
      }
      System.out.println(monsters.get(m).getName()+"にボールを投げた");
      player.balls.decrement();
      if(monsters.get(m).getRate()<=r){//monsterRare[m]の値がr以下の場合
        System.out.println(monsters.get(m).getName()+"を捕まえた！");
        player.monster.add(monsters.get(m).getName());
        break;//ボール投げ終了
      }else{
        System.out.println(monsters.get(m).getName()+"に逃げられた！");
      }
    }
  }

  private void hatchingEgg(Player player) {
    MonsterZukan monsters = new MonsterZukan();
    Integer tmp = player.egg.hatching();
    IntStream.range(0, tmp)
      .forEach(v -> {
        System.out.println("卵が孵った！");
        int m = (int)(monsters.size()*Math.random());
				System.out.println(monsters.get(m).getName() + "が産まれた！");
				player.monster.add(monsters.get(m).getName());
      });
  }
}
