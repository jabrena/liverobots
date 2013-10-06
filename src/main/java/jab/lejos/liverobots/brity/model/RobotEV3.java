package jab.lejos.liverobots.brity.model;

import java.util.Random;

import lejos.nxt.ADSensorPort;
import lejos.nxt.EV3ColorSensor;
import lejos.nxt.I2CPort;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.SoundSensor;
import lejos.nxt.UARTPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;

public class RobotEV3 extends Robot {

	//Sensors
	private SoundSensor leftSound;
	private SoundSensor rightSound;
	private UltrasonicSensor ultrasonic;
	private LightSensor lightSensor;
	
	//Actuators
	private RegulatedMotor leftMotor;
	private RegulatedMotor rightMotor;
	private final int speedMotor = 720;
	
	private DifferentialPilot dPilot;
	private final float wheelDiameter = 4.0F;
	private final float trackWidth = 14.6F;
	private final boolean reverse = false;
	private PoseProvider posep;
	private Navigator nav;
	
	private RobotEV3(){
		super(RobotType.EV3);
		leftSound = new SoundSensor((ADSensorPort) SensorPort.S1);
		rightSound = new SoundSensor((ADSensorPort) SensorPort.S2);
		leftSound.setDBA(true);
		rightSound.setDBA(true);
		ultrasonic = new UltrasonicSensor((I2CPort) SensorPort.S3);
		lightSensor = new LightSensor((ADSensorPort) SensorPort.S4);
		lightSensor.setFloodlight(false);

		leftMotor = Motor.A;
		rightMotor = Motor.C;
		leftMotor.setSpeed(speedMotor);
		rightMotor.setSpeed(speedMotor);
		
		//TODO Add a local navigation system
		dPilot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor,reverse);
		posep = new OdometryPoseProvider(dPilot);
		nav = new Navigator(dPilot,posep);
		Pose start = new Pose(0,0,0);
		
	}
	
	//Singleton pattern
	private static RobotEV3 INSTANCE = null;
	
	public static RobotEV3 getInstance() {
        if (INSTANCE == null) {
            synchronized(RobotEV3.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new RobotEV3();
                }
            }
        }
        
        return INSTANCE;
    }

	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
	
	public int getDistance(){
		
		int distance = -1;
		
		float ranges[];
		ranges = ultrasonic.getRanges();
		if(ranges.length > 0){
			if(ranges.length == 1){
				distance = Math.round(ranges[0]);
			}else if(ranges.length == 2){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/2);
			}else if(ranges.length == 3){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/3);
			}
		}
		
		return distance;
	}
	
	public void forward(int seconds){
		leftMotor.forward();
		rightMotor.forward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public void backward(int msecs){
		leftMotor.backward();
		rightMotor.backward();
		try { Thread.sleep(msecs); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public void turnRight(int seconds){
		leftMotor.forward();
		rightMotor.backward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}

	public void turnLeft(int seconds){
		leftMotor.backward();
		rightMotor.forward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public int getLeftSound(){
		return leftSound.readValue();
	}

	public int getRightSound(){
		return rightSound.readValue();
	}

	public int getDiffSound(){
		return Math.abs(leftSound.readValue() - rightSound.readValue());
	}
	
	public int getLightLeve(){
		System.out.println(lightSensor.getLightValue());
		System.out.println(lightSensor.getNormalizedLightValue());
		return lightSensor.getNormalizedLightValue();
	}
	
	public void shortSound(int tones, int freqValue){
		Random rnd = new Random();
	    for(int i=0; i<=tones; i++){
	        int frequency = rnd.nextInt(freqValue);
	        int duration = rnd.nextInt(1000);
	        Sound.setVolume(rnd.nextInt(20));
	        Sound.playTone(i*frequency, duration);
	        try { Thread.sleep(100); } catch (InterruptedException e) {}
	    }		
	}

	@Override
	public int getVoltage() {
		int voltage  = 0;
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(500);
		if(randomInt < 200){
			voltage = randomInt;
		}else{
			voltage = 500;
		}
		voltage = 500;
		return voltage;
	}
	
}
