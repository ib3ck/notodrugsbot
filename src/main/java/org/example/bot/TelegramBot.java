package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            long chatId = message.getChatId();

            if (message.getText().equals("/start")) {
                sendKeyboardMessage(chatId);
            }
            else if (message.getText().equals("Консультации по НПВ (новые психоактивные вещества)")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у специалиста по НПВ: @Dmitri1827");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("ВИЧ, АРВТ, приверженность к лечению и доступу к медуслугам")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у специалиста: @webconsoskemen");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("Консультации по ПТАО (поддерживающая терапия агонистами опиоидов в Казахстане)")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у специалиста по ПТАО: @kapelca_yada");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("НаркоЭксперт (врач нарколог)")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у врача нарколога: @svezhie_podkhody");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("ГинекоСпец (врач гинеколог)")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у врача гинеколога: @svezhie_podkhody0");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("Консультирование по сопутствующим заболеваниями (ВГС, ИПП)")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у специалиста по сопутствующим заболеваниями (ВГС, ИПП): @Dmitri1827");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().startsWith("Консультирование по юридическим вопросам ")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у специалиста по юридическим вопросам: @Ania_537");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("Консультант по передозировкам")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у специалиста по передозировкам: @Ania_537");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("Консультант по химичиской зависимости")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Вы можете получить консультацию у специалиста по химичиской зависимости: @Volonter_jez");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (message.getText().equals("/off")) {
                startAgain(chatId);
            }

//            if (message.getText().equals("/showButtons")) {
//                sendButtonsMessage(chatId);
//            }
        }
    }

    private void startAgain(long chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("""
            Ваша подписка деактивирована.

            Вы всегда можете включить ее снова с помощью команды /start""");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        KeyboardButton button1 = new KeyboardButton("/start");
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(button1);
        markup.setKeyboard(List.of(keyboardRow1));

        markup.setResizeKeyboard(true); // Allow the keyboard to be resized by the user
        markup.setOneTimeKeyboard(false); // Hide the keyboard after the user selects an option
        markup.setSelective(false); // Show the keyboard to all users

        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendKeyboardMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("""
                Первая доврачебная помощь при передозировке

                Используйте /off чтобы приостановить подписку.""");
        message.setReplyMarkup(createKeyboardMarkup());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup createKeyboardMarkup() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        // Create a new row of buttons
        KeyboardButton button1 = new KeyboardButton("Консультации по НПВ (новые психоактивные вещества)");
        KeyboardButton button2 = new KeyboardButton("ВИЧ, АРВТ, приверженность к лечению и доступу к медуслугам");
        KeyboardButton button3 = new KeyboardButton("Консультации по ПТАО (поддерживающая терапия агонистами опиоидов в Казахстане)");
        KeyboardButton button4 = new KeyboardButton("НаркоЭксперт (врач нарколог)");
        KeyboardButton button5 = new KeyboardButton("ГинекоСпец (врач гинеколог)");
        KeyboardButton button6 = new KeyboardButton("Консультирование по сопутствующим заболеваниями (ВГС, ИПП)");
        KeyboardButton button7 = new KeyboardButton("Консультирование по юридическим вопросам ( алгоритм действий для снятия ареста со счетов, взыскание алиментов, оформление пособий и инвалидности, помощь в составлении досудебных претензий и исковых заявлений)");
        KeyboardButton button8 = new KeyboardButton("Консультант по передозировкам");
        KeyboardButton button9 = new KeyboardButton("Консультант по химичиской зависимости");

        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardRow keyboardRow4 = new KeyboardRow();
        KeyboardRow keyboardRow5 = new KeyboardRow();
        KeyboardRow keyboardRow6 = new KeyboardRow();
        KeyboardRow keyboardRow7 = new KeyboardRow();
        KeyboardRow keyboardRow8 = new KeyboardRow();
        KeyboardRow keyboardRow9 = new KeyboardRow();

        keyboardRow1.add(button1);
        keyboardRow2.add(button2);
        keyboardRow3.add(button3);
        keyboardRow4.add(button4);
        keyboardRow5.add(button5);
        keyboardRow6.add(button6);
        keyboardRow7.add(button7);
        keyboardRow8.add(button8);
        keyboardRow9.add(button9);

        // Add buttons to the row
        markup.setKeyboard(List.of(keyboardRow1, keyboardRow2, keyboardRow3,keyboardRow4, keyboardRow5, keyboardRow6, keyboardRow7, keyboardRow8, keyboardRow9));

        // Set other options for the keyboard (optional)
        markup.setResizeKeyboard(true); // Allow the keyboard to be resized by the user
        markup.setOneTimeKeyboard(false); // Hide the keyboard after the user selects an option
        markup.setSelective(false); // Show the keyboard to all users

        return markup;
    }

    private void sendButtonsMessage(long chatId) {
        SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Select an option:");
                message.setReplyMarkup(createInlineKeyboardMarkup());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private InlineKeyboardMarkup createInlineKeyboardMarkup() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        // Create a button
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Button Text");
        button.setCallbackData("button_callback_data"); // This data will be sent to your bot when the button is clicked

        // Create a row of buttons
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);

        // Add the row to the keyboard
        keyboard.add(row);

        // Set the keyboard in the markup
        markup.setKeyboard(keyboard);

        return markup;
    }

    @Override
    public String getBotToken() {
        return "6576066120:AAHsms6j0xMDEYX4x2kXqHAW0kcLUqmpub4";
    }

    @Override
    public String getBotUsername() {
        return "notodrugs_bot";
    }
}
