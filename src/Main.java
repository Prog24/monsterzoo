public class Main {

	public static void main(String[] args) {
		Player player = new Player();
		Event event = new Event();

		//1000ミリ秒（1秒）ずつ止まりながらevent.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(player.balls.count()>0){
					event.move(player);
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ボールがなくなった！");

		for(int i=0;i<player.monster.size();i++){
			if(player.monster.get(i)!=null){
				System.out.println(player.monster.get(i)+"を捕まえた．");
			}
		}
	}

}
