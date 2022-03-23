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
		ArrayList<RaceCar> finalists = new ArrayList<RaceCar>();
		ArrayList<Integer> finalistDistances = new ArrayList<Integer>();
		for (RaceCar raceCar : racers)	{
			if (raceCar.getMetersTravelled() > raceTrackDistance) {
				finalists.add(raceCar);
				finalistDistances.add(raceCar.getMetersTravelled());
			}
		}
		if (finalists.size() == 1) {
			return "WINNER: " + finalists.get(0).getNameAndMake();
		}
		else {
			int maxDistance = 0;
			int count = 0;
		    for (RaceCar raceCarToCheck : finalists) {
			    int raceCarToCheckDistance = raceCarToCheck.getMetersTravelled();
			    if (maxDistance == 0) {
			    	maxDistance = raceCarToCheckDistance;
			    	count = 1;
			    }
			    else if (raceCarToCheckDistance > maxDistance) {
			    	maxDistance = raceCarToCheckDistance;
			    	count = 1;
			    }
			    else if (raceCarToCheckDistance == maxDistance) {
			    	count += 1;
			    }
		    }
		    if (count > 1) {
		    	return "TIE";
		    }
		    else {
		    	int winningIndex = finalistDistances.indexOf(maxDistance);
		    	RaceCar winner = finalists.get(winningIndex);
		    	return "WINNER: " + winner.getNameAndMake();
		    	
		    }
		}
	}

	public void progressWeather() 
	{
		raceWeather.changeWeather();
	}
	
	public void changeCarBehaviour(int position, DrivingBehavior drivingBehavior) 
	{
		racers.get(position).changeDrivingBehaviour(drivingBehavior);
		
	}

	public void raceStep() 
	{
		for (RaceCar raceCar: racers) {
			raceCar.driveCar();
			System.out.println(raceCar.getStatus());
		}

	}

	public boolean isFinished()
	{
		for (RaceCar raceCar: racers) {
			if (raceCar.getMetersTravelled() > raceTrackDistance) {
				return true;
			}
		}
		return false;
	}

	private void makeFourCars() 
	{
		DrivingBehavior cautiousDrivingBehavior = new CautiousDriving(raceWeather);
		DrivingBehavior fastDrivingBehavior = new FastDriving(raceWeather);
		RaceCar raceCar1 = new RaceCar("Fjord","Car 1", raceWeather, cautiousDrivingBehavior);
		RaceCar raceCar2 = new RaceCar("Fjord","Car 2", raceWeather, fastDrivingBehavior);
		RaceCar raceCar3 = new RaceCar("Furbi","Car 3", raceWeather, cautiousDrivingBehavior);
		RaceCar raceCar4 = new RaceCar("Furbi","Car 4", raceWeather, fastDrivingBehavior);
		racers.add(raceCar1);
		racers.add(raceCar2);
		racers.add(raceCar3);
		racers.add(raceCar4);
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
