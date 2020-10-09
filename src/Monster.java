public class Monster {
  final private String name;
  final private Integer rate;
  public Monster(String name, Integer rate) {
    this.name = name;
    this.rate = rate;
  }

  public String getName() {
    return this.name;
  }

  public Integer getRate() {
    return this.rate;
  }
}
