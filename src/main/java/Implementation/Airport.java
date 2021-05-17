package Implementation;

public class Airport {
    private String code;
    private String name;
    private String city;
    private String country;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLattitude() {
        return lattitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public Airport(String code, String name, String city, String country, String lattitude, String longtitude) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.lattitude = lattitude;
        this.longtitude = longtitude;
    }

    private String lattitude;
    private String longtitude;

    @Override
    public String toString(){
        return "code: " + code + " name: " + name + " city: " + city + " country: " + country + "lattitude: " + lattitude;
    }
}
