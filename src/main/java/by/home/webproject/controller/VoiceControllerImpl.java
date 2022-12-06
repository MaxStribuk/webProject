package by.home.webproject.controller;

import by.home.webproject.repository.ResultGenerator;
import by.home.webproject.repository.ResultGeneratorImpl;
import by.home.webproject.repository.VoiceRepository;
import by.home.webproject.repository.VoiceRepositoryImpl;

import javax.servlet.http.HttpServletRequest;

public final class VoiceControllerImpl implements VoiceController {

    private static volatile VoiceControllerImpl instance;
    private final VoiceRepository voiceRepository;
    private final ResultGenerator resultGenerator;

    private VoiceControllerImpl() {
        resultGenerator = new ResultGeneratorImpl();
        voiceRepository = new VoiceRepositoryImpl();
    }

    public static VoiceControllerImpl getInstance() {
        VoiceControllerImpl result = instance;
        if (result != null) {
            return result;
        }
        synchronized (VoiceControllerImpl.class) {
            if (instance == null) {
                instance = new VoiceControllerImpl();
            }
            return instance;
        }
    }

    @Override
    public boolean vote(HttpServletRequest req) {
        return voiceRepository.vote(req);
    }

    @Override
    public String getResult(boolean isCorrectVoice) {
        return resultGenerator.generateResult(isCorrectVoice);
    }

    @Override
    public VoiceRepository getVoiceRepository() {
        return voiceRepository;
    }
}