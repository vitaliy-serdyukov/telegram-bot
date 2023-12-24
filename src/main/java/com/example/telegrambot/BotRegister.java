package com.example.telegrambot;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotRegister {


    private final VacanciesBot vacanciesBot;
    public BotRegister(VacanciesBot vacanciesBot) {
        this.vacanciesBot = vacanciesBot;
    }


   /* @PostConstruct
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(vacanciesBot);
    }*/

    @PostConstruct
    public void init() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(vacanciesBot);
        } catch (TelegramApiException e) {
            // Log the exception
            e.printStackTrace();
        }
    }
}
