package by.home.webproject.controller;

import by.home.webproject.repository.VoiceRepository;

import javax.servlet.http.HttpServletRequest;

public interface VoiceController {

    boolean vote(HttpServletRequest req);
    String getResult(boolean isCorrectVoice);
    VoiceRepository getVoiceRepository();
}