package jab.lejos.liverobots.brity;

import lejos.nxt.Sound;

public class BrityTest {	

	public static void main(String[] args){

		Brity b = new Brity();
		Sound.setVolume(30);
		Sound.beepSequenceUp();

		int iterationCounter = 0;
		
		//while ((!Button.ESCAPE.isDown()) || (!(iterationCounter >= 10))) {
		while (!(iterationCounter >= 20)) {
		//for(int i=0; i<=10; i++){	

			b.debugBrity();
			
			if((b.getRobot().getDiffSound() <= 10) && (b.getRobot().getLeftSound() < 5)){
				System.out.println("Brity is happy. It likes silences");
			}else{
				System.out.println("Brity is annoyed. It likes silences");
				b.getRobot().shortSound(5, 1000);				
			}
			
			if(b.getRobot().getLightLeve() <= 200){

			}else{
				System.out.println("Brity is annoyed. It likes dark places");
				b.getRobot().backward(200);				
			}
			
			System.out.println("=======");
			
			iterationCounter++;
			
			try { Thread.sleep(1000); } catch (InterruptedException e) {};
	    }
		
		Sound.beepSequence();

		
		System.out.println("EXIT");		
		System.exit(0);
	}
	
}
