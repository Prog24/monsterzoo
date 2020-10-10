public class Ball {
  private Integer count;
  public Ball() {
    this.count = 10;
  }

  public void add(Integer num) {
    this.count += num;
  }

  public void decrement() {
    this.count -= 1;
  }

  public Integer count() {
    return this.count;
  }

  public void throwBall(Integer r, Player player, Monster encountMonster) {
    System.out.println(encountMonster.name+"にボールを投げた");
    player.balls.decrement();
    if(encountMonster.rate > r) {
      System.out.println(encountMonster.name+"に逃げられた");
      return;
    }
    System.out.println(encountMonster.name+"を捕まえた！");
    player.monster.add(encountMonster.name);
    return;
  }
}
