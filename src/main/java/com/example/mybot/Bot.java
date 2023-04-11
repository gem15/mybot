package com.example.mybot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author Gennagy Mann
 * https://api.telegram.org/bot5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA/getUpdates
 */
@Slf4j
@Component
public class Bot extends TelegramLongPollingBot {
    //    private static final String TOKEN = "5578332030:AAEcnkr-SQnuZhoOFD-s6uZMVLy0NC_BY1A";//emds
    private static final String TOKEN = "5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA";//gnustopal_bot
    private static final String USERNAME = "Ris";

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
//    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            String chatId = Long.toString(update.getMessage().getChatId());
            try {
                execute(new SendMessage(chatId, "Echo  " + update.getMessage().getText()));
                log.info("ChatId = " + chatId);
//                mySendDocument(chatId);
            } catch (TelegramApiException e) {
                log.info(e.getMessage());
            }
        } else if (update.getMessage().getDocument() != null) {
            var doc = update.getMessage().getDocument();
            String jsonFile = null;
            try {
                jsonFile = uploadJson(doc.getFileName(), doc.getFileId());
            } catch (JsonProcessingException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
            log.info(jsonFile);
        }

    }

    public String uploadJson(String fileName, String fileId) throws JsonProcessingException, WebClientResponseException {
        WebClient webClient = WebClient.create();
        // по fileId получаем file_path
//        String ur = "https://api.telegram.org/bot5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA/getFile?file_id=BQACAgIAAxkBAAOtZDQkeLAeqBE4NUIWfRC11ICOXCoAAvkpAAJqUaBJkh6szfMdnyMvBA";
        String url = "https://api.telegram.org/bot" + TOKEN + "/getFile?file_id=" + fileId;
        String fileInfo = webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
/*
        String filePath = """
                    {
                        "ok": true,
                        "result": {
                            "file_id": "BQACAgIAAxkBAAOtZDQkeLAeqBE4NUIWfRC11ICOXCoAAvkpAAJqUaBJkh6szfMdnyMvBA",
                            "file_unique_id": "AgAD-SkAAmpRoEk",
                            "file_size": 228,
                            "file_path": "documents/file_0.json"
                        }
                    }
                        """;
*/

        // используя  file_path загружаем файл
        final JsonNode node = new ObjectMapper().readTree(fileInfo).get("result");
//        String ur2 = "https://api.telegram.org/file/bot5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA/documents/file_0.json";
        url="https://api.telegram.org/file/bot" + TOKEN + "/" + node.get("file_path").asText();
        String json = webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
/*
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String call = ow.writeValueAsString(json);
*/
        return json;
    }

    public void mySendDocument(String chatId) throws TelegramApiException {
        SendDocument document = new SendDocument();
        document.setChatId(chatId);
        document.setCaption("Отчёт ЛИС.Администрирование");
        String test = "Привет world;";
        InputStream mediaStream = new ByteArrayInputStream(test.getBytes(Charset.forName("Cp1251")));
        InputFile doc = new InputFile(mediaStream, "lis.csv");
        document.setDocument(doc);
        execute(document);
    }
}
