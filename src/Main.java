public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.player.balls.count()>0){
					pz.move();
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ボールがなくなった！");

		for(int i=0;i<pz.player.monster.size();i++){
			if(pz.player.monster.get(i)!=null){
				System.out.println(pz.player.monster.get(i)+"を捕まえた．");
			}
		}
	}

}
