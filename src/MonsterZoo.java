import java.util.stream.IntStream;

public class MonsterZoo {
	public Player player = new Player();
	public Event event = new Event();
	public void move() {
		event.move(player);
	}

}
