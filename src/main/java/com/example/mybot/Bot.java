package com.example.mybot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @Author Gennagy Mann
 */
@Slf4j
@Component
public class Bot extends TelegramLongPollingBot {
    private static final String TOKEN = "5578332030:AAEcnkr-SQnuZhoOFD-s6uZMVLy0NC_BY1A";//emds
//    private static final String TOKEN = "5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA";//mybot
    private static final String USERNAME =  "Ris";

/*
    public Bot(DefaultBotOptions options){
        super(options);
    }
*/

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage()!=null&&update.getMessage().hasText()){
        long chatId = update.getMessage().getChatId();
            try {
                execute(new SendMessage(Long.toString(chatId),"Приветики "+update.getMessage().getText()));
                log.info("ChatId = "+Long.toString(chatId));
//                execute(new SendMessage(Long.toString(chatId),Long.toString(chatId)));
            } catch (TelegramApiException e) {
                log.info("смотрим ошибку...");
                e.printStackTrace();
            }
        }

    }
}
