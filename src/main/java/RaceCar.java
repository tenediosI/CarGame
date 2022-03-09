
public class RaceCar {
	
	private int metersTravelled = 0;
	private String manufacturer;
	private String carName;

	
	public RaceCar(String manufacturer, String carName) 
	{
		this.manufacturer = manufacturer;
		this.carName = carName;
		
	}

	public void driveCar()
	{
		// to implement
	}
	
	public void changeDrivingBehaviour()
	{
		// to implement
	}

	
	public String getStatus()
	{
		return carName + " built by " + manufacturer + " has travelled " + metersTravelled +" meters";
	}
	

}
