public class a2_pojo_cricketers {

    private String name;
    private String playingStyle;
    private int matches;
    private int runs;
    private double average;


    public a2_pojo_cricketers(String name, String playingStyle, int matches, int runs, double average) {
        this.name = name;
        this.playingStyle = playingStyle;
        this.matches = matches;
        this.runs = runs;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayingStyle() {
        return playingStyle;
    }

    public void setPlayingStyle(String playingStyle) {
        this.playingStyle = playingStyle;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }





}
