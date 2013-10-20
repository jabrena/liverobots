package jab.lejos.liverobots.model;

public class RobotFactoryException extends Exception {

	static final long serialVersionUID = 1234567890L;
	
	public RobotFactoryException() {}

    public RobotFactoryException(final String message){
    	super(message);
    }
}
