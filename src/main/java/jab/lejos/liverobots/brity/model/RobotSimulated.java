package jab.lejos.liverobots.brity.model;

import java.util.Random;

public class RobotSimulated extends Robot {

	private RobotSimulated(RobotType type){
		super(type);
	}
	
	//Singleton pattern
	private static RobotSimulated INSTANCE = null;
	
	public static RobotSimulated getInstance() {
        if (INSTANCE == null) {
            synchronized(RobotSimulated.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new RobotSimulated(RobotType.SIMULATED);
                }
            }
        }
        
        return INSTANCE;
    }

	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
	
	public int getDistance(){
		int distance  = 0;
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if(randomInt < 100){
			distance = randomInt;
		}else{
			distance = 150;
		}
		return distance;
	}

	public int getVoltage() {
		int voltage  = 0;
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(500);
		if(randomInt < 200){
			voltage = randomInt;
		}else{
			voltage = 500;
		}
		return voltage;
	}

}
