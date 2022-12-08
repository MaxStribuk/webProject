package by.home.webproject.dto;

public class SingerDTO {

    private final String name;

    public SingerDTO(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}