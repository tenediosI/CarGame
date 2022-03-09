public enum WeatherType {
    DRY, WET, MISTY;

    public WeatherType next(){
        return values()[(ordinal()+1)%3];
    }
}
