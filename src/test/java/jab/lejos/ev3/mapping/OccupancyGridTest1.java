package jab.lejos.ev3.mapping;

import java.util.Random;

import jab.lejos.liverobots.model.beetle.BeetleRobotEV3;

public class OccupancyGridTest1 {

	public static void main(String[] args) {

		int size = 30;
		OccupancyGridMap cgm = new OccupancyGridMap(size,size);
		
		float distance = 0;
		
		BeetleRobotEV3 robot = BeetleRobotEV3.getInstance();
		System.out.println("pose = " + robot.getPose());
		robot.travel(10);
		distance = robot.getFrontDistance();
		cgm.update(robot.getPose(), distance);
		System.out.println("pose = " + robot.getPose());	
		robot.travel(20);
		System.out.println("pose = " + robot.getPose());	
		robot.travel(40);
		System.out.println("pose = " + robot.getPose());
		robot.travel(60);
		System.out.println("pose = " + robot.getPose());
		/*
		Random randomGenerator = new Random();	
		
		int move;
		// make 10 random movements	
		for (int i=0; i < 10; i++) {	
			move = randomGenerator.nextInt(2); 	
			if (move == 0) { // move forward		
				robot.travel(10); //Moves forward for 10cm	
			} else {
				robot.rotate(90);
			}	
			System.out.println("pose = " + robot.getPose());
		}
		*/
	}

}
