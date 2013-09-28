package jab.lejos.liverobots;


import lejos.nxt.Button;
import lejos.nxt.Sound;

public class Brity {	

	private static BrityBody brityBody;
	
	public static void main(String[] args){

		brityBody = new BrityBody();
		Sound.setVolume(30);
		Sound.beepSequenceUp();

		int iterationCounter = 0;
		
		//while ((!Button.ESCAPE.isDown()) || (iterationCounter > 10)) {
		while (!(iterationCounter >= 20)) {
		//for(int i=0; i<=10; i++){	

			debugBrity();
			
			if((brityBody.getDiffSound() <= 10) && (brityBody.getLeftSound() < 5)){
				System.out.println("Brity is happy. It likes silences");
			}else{
				System.out.println("Brity is annoyed. It likes silences");
				brityBody.shortSound(5, 1000);				
			}
			
			if(brityBody.getLightLeve() <= 200){

			}else{
				System.out.println("Brity is annoyed. It likes dark places");
				brityBody.backward(200);				
			}
			
			System.out.println("=======");
			
			iterationCounter++;
			
			try { Thread.sleep(1000); } catch (InterruptedException e) {};
	    }
		
		Sound.beepSequence();

		
		System.out.println("EXIT");		
		System.exit(0);
	}

	private static void debugBrity(){
		System.out.println("LS: " + brityBody.getLeftSound());
		System.out.println("RS: " + brityBody.getRightSound());
		System.out.println("DS: " + brityBody.getDiffSound());
		System.out.println("D:  " + brityBody.getDistance());
		System.out.println("LS: " + brityBody.getLightLeve());
		System.out.println("=======");
	}
	
}
