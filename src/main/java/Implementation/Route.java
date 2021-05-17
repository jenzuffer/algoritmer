package Implementation;

public class Route {
    private String airline_code;
    private String source_code;
    private String destination_code;
    private double distance;

    public String getAirline_code() {
        return airline_code;
    }

    public String getSource_code() {
        return source_code;
    }

    public String getDestination_code() {
        return destination_code;
    }

    public double getDistance() {
        return distance;
    }

    public String getTime() {
        return time;
    }

    public Route(String airline_code, String source_code, String destination_code, double distance, String time) {
        this.airline_code = airline_code;
        this.source_code = source_code;
        this.destination_code = destination_code;
        this.distance = distance;
        this.time = time;
    }

    private String time;

    @Override
    public String toString() {
        return "airline_code: " + airline_code + " source_code: " + source_code + " destination_code: " + destination_code
                + " distance: " + distance + " time: " + time;
    }
}
