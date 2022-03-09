import java.util.ArrayList;

public class Race 
{
	private RaceWeather raceWeather;
	private int raceTrackDistance;
	private ArrayList<RaceCar> racers = new ArrayList<RaceCar>();
	private final int numberOfStepsToChange = 5;
	
	public Race(WeatherType weather, int raceTrackDistance)
	{
		raceWeather = new RaceWeather(weather);
		this.raceTrackDistance = raceTrackDistance;
	}
	
	private String getOutcome() 
	{
		// to implement
		return null;
	}

	public void progressWeather() 
	{
		raceWeather.changeWeather();
	}
	
	public void changeCarBehaviour(int position) 
	{
		// to implement
		
	}

	public void raceStep() 
	{

	}

	public boolean isFinished()
	{
		// to implement
		return true;
	}

	private void makeFourCars() 
	{
		// to implement
	}

	public void raceCars(){
		int stepCount = 0;
		while(!isFinished())
		{
			stepCount++;
			raceStep();
			if (stepCount%numberOfStepsToChange==0)
			{
				progressWeather();
			}
		}
	}
	

	public static void main(String[]args)
	{
		Race race = new Race(WeatherType.DRY, 100);
		race.makeFourCars();
		race.raceCars();
		System.out.println(race.getOutcome());
	}
}
