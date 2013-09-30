package jab.lejos.liverobots.brity.dao;

import java.util.List;

public interface IBritySensorDAO {
	public List<BritySensorMeasure> getAllMeasures();
	public void addSensorMeasure(BritySensorMeasure measure);
	public void deleteSensorMeasures();
	public void createSensorMeasureStructure();
}
