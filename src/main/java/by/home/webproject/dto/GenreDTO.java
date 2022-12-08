package by.home.webproject.dto;

public class GenreDTO {

    private final String title;

    public GenreDTO(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}