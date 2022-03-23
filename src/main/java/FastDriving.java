
public class FastDriving implements DrivingBehavior{
	private RaceWeather raceWeather;
	private WeatherType weather;
	
	public FastDriving(RaceWeather raceWeather) {
		this.raceWeather = raceWeather;
		
	}
	public int driveCar() {
		weather = raceWeather.getWeather();
		if (weather == WeatherType.DRY) {
			return 20;
		}
		else if (weather == WeatherType.MISTY){
			return 5;
		}
		else {
			return 8;
		}
	}

}
