package jab.lejos.liverobots.model.bumpercar;

import jab.lejos.liverobots.model.RobotType;

import java.util.Random;

import org.apache.log4j.Logger;

public class BumperCarRobotSimulated extends BumpercarRobot {

	Logger logger = Logger.getLogger(BumperCarRobotSimulated.class);
	
	private BumperCarRobotSimulated(RobotType type){
		super(type);
	}
	
	//Singleton pattern
	private static BumperCarRobotSimulated INSTANCE = null;
	
	public static BumperCarRobotSimulated getInstance() {
        if (INSTANCE == null) {
            synchronized(BumperCarRobotSimulated.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new BumperCarRobotSimulated(RobotType.SIMULATED);
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

	public int getBatteryVoltage() {
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

	public void forward(int i) {
		logger.info("FORWARD");
	}

	public void backward(int i) {
		logger.info("BACKWARD");
	}

	public void turnLeft(int i) {
		logger.info("TURN LEFT");
	}

	@Override
	public void turnRight(int i) {
		// TODO Auto-generated method stub
		
	}

}
