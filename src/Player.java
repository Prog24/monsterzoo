public class Player {
  public Ball balls = new Ball();
  public Distance distance = new Distance();
  public Fruits fruits = new Fruits();
  public UserMonster monster = new UserMonster();
  public Egg egg = new Egg();

  public void walk() {
    this.distance.increment();
    this.egg.walk();
  }

  public void nowStatus() {
    System.out.println("手持ちのボールは"+this.balls.count()+"個，フルーツは"+this.fruits.count()+"個");
    System.out.println(this.distance.get()+"km歩いた．");
  }
}
