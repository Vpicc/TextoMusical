package textoMusical;

import org.jfugue.Pattern;
import org.jfugue.Player;

class MultiThreads implements Runnable {
	private String threadName;
	private Player player;
	
	MultiThreads( String name, Player aplayer) {
		threadName = name;
		player = aplayer;
	}
	@Override
	public void run() {
		System.out.println ("Thread " + threadName  + " is running");
		
		if(new String("PLAYS").equals(threadName)) {

			//player.play(pattern);
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