package Implementation;

public class Airline {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    private String country;

    public Airline(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString(){
        return "code: " + code + " name: " + name + " country: " + country;
    }
}
