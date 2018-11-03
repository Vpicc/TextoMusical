import org.jfugue.Pattern;
import org.jfugue.Player;
class MultiThread implements Runnable {
	private String threadName;
	private Player player;
	
	MultiThread( String name, Player aplayer) {
		threadName = name;
		player = aplayer;
	}
	@Override
	public void run() {
		System.out.println ("Thread " + threadName  + " is running");
		
		if(new String("PLAYS").equals(threadName)) {
			Pattern pattern = new Pattern("I[Flute] X[Volume]=10200 T0 C D E F X[Volume]=5400 I[Piano] G A B");
			player.play(pattern);
		}
		
		if(new String("STOP").equals(threadName)) {
			try {
				Thread.sleep(2000);
				if(player.isPlaying()) {
					System.out.println ("Trying to stop");
					player.stop();
				}
			} catch (Exception e) {
				System.out.println ("Exception");
			}
		}
		
		
	}
}
public class TextoMusical {
	

	public static void main(String[] args) {
		Player player = new Player();
		//Thread test2 = new Thread(new MultiThread("STOP",player));
		//test2.start();
		Thread test1 = new Thread(new MultiThread("PLAYS",player));
		test1.start();
		//Pattern pattern = new Pattern("I[Flute] X[Volume]=10200 T80 C D E F X[Volume]=5400 G A B B B B B B B B B B B");
		//player.play(pattern);

		
	}

}
