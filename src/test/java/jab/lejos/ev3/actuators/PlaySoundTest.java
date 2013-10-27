package jab.lejos.ev3.actuators;

import java.util.Random;

import lejos.hardware.Sound;

public class PlaySoundTest {
	public static void main(String[] args) throws InterruptedException {
		//final File soundFile = new File("./res/r2d2.wav");
		//Sound.setVolume(100);
		//Sound.playSample(soundFile, 100); // 100 ... volume
		//Sound.beepSequenceUp();
		//Sound.beepSequence();
		//Sound.beep();
		Sound.setVolume(10);
		shortSound(10,100);
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		shortSound(10,300);
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		shortSound(10,500);
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		shortSound(10,1000);
		
		
		//Button.ENTER.waitForPressAndRelease();
		
		System.out.println("EXIT");		
		System.exit(0);
	}
	
	public static void shortSound(int tones,int freqValue){
		Random rnd = new Random();
	    for(int i=0; i<=tones; i++){
	        int frequency = rnd.nextInt(freqValue);
	        int duration = rnd.nextInt(1000);
	        Sound.setVolume(rnd.nextInt(20));
	        //Sound.playTone(i*frequency, duration);
	        Sound.playTone(frequency, duration);
	        try { Thread.sleep(100); } catch (InterruptedException e) {}
	    }		
	}
}