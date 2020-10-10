public class Fruits {
  private Integer count;

  public Fruits() {
    this.count = 0;
  }

  public Integer count() {
    return this.count;
  }

  public void add(Integer num) {
    this.count += num;
  }

  public void decrement() {
    this.count -= 1;
  }

  public Integer throwFruits(Integer r, Player player) {
    if (player.fruits.count() > 0) {
      System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
      player.fruits.decrement();
      r = r * 2;
    }
    return r;
  }
}
