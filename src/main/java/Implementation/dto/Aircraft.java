package Implementation.dto;

public class Aircraft {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Aircraft(String code, String name, String category) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    private String category;

    @Override
    public String toString(){
        return "code: " + code + " name: " + name + " category: " + category;
    }
}
