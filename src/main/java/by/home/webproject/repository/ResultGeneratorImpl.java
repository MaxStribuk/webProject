package by.home.webproject.repository;

import by.home.webproject.controller.VoiceControllerImpl;

import java.util.Map;

public class ResultGeneratorImpl implements ResultGenerator {

    private final String INCORRECT_COUNT_GENRES = """
            <p>К сожалению, Ваш голос не был учтен,</p>
            <p>вы не выполнили обязательные условия для голосования.</p>
            <p>Пожалуйста, повторите попытку.</p>
            """;

    @Override
    public String generateResult(boolean isCorrectVoice) {
        return isCorrectVoice ? createMessage() : INCORRECT_COUNT_GENRES;
    }

    private String createMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("<h2>Список лучших исполнителей:</h2>");
        VoiceControllerImpl.getInstance()
                .getVoiceRepository()
                .getActors()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> builder.append("<p>").append(entry).append("</p>"));
        builder.append("<h2>Список любимых жанров:</h2>");
        VoiceControllerImpl.getInstance()
                .getVoiceRepository()
                .getGenres()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> builder.append("<p>").append(entry).append("</p>"));
        builder.append("<h2>Информация о голосующих:</h2>");
        VoiceControllerImpl.getInstance()
                .getVoiceRepository()
                .getTexts()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, String>comparingByKey().reversed())
                .forEach(entry -> builder.append("<p>").append(entry).append("</p>"));
        return builder.toString();
    }
}
