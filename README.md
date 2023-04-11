
# Инструкция

### mybot

[Минимальный «hello world» telegram-бот](https://habr.com/ru/post/306222/)

[Tests](#Создание бота)
https://api.telegram.org/bot5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA/getUpdates

https://api.telegram.org/bot5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA/sendMessage?chat_id=827188983&text=Привет%20мир
{"ok":true,"result":[{"update_id":8520055,
"message":{"message_id":101,"from":{"id":827188983,"is_bot":false,"first_name":"gem","username":"gemnnn","language_code":"ru"},"chat":{"id":827188983,"first_name":"gem","username":"gemnnn","type":"private"},"date":1666793810,"text":"/start","entities":[{"offset":0,"length":6,"type":"bot_command"}]}}]}
2. Создать группу `ЕМДС Статистика`
3. Добавить бота `emdsbot`
4. Сделать запрос `https://api.telegram.org/bot5578332030:AAEcnkr-SQnuZhoOFD-s6uZMVLy0NC_BY1A/getUpdates`
5. Взять chatId новой группы `"id": -623258985`

```json
{
  "ok": true,
  "result": [
    {
      "update_id": 561414961,
      "my_chat_member": {
        "chat": {
          "id": -623258985,
          "title": "EMDS статистика",
          "type": "group",
          "all_members_are_administrators": true
        },
        "from": {
          "id": 853632516,
          "is_bot": false,
          "first_name": "Павел",
          "last_name": "Назаров",
          "language_code": "ru"
        },
        "date": 1655901684,
        "old_chat_member": {
          "user": {
            "id": 5578332030,
            "is_bot": true,
            "first_name": "ЕМДС",
            "username": "ris_emds_bot"
          },
          "status": "left"
        },
        "new_chat_member": {
          "user": {
            "id": 5578332030,
            "is_bot": true,
            "first_name": "ЕМДС",
            "username": "ris_emds_bot"
          },
          "status": "member"
        }
      }
    },
    {
      "update_id": 561414962,
      "message": {
        "message_id": 73,
        "from": {
          "id": 853632516,
          "is_bot": false,
          "first_name": "Павел",
          "last_name": "Назаров",
          "language_code": "ru"
        },
        "chat": {
          "id": -623258985,
          "title": "EMDS статистика",
          "type": "group",
          "all_members_are_administrators": true
        },
        "date": 1655901684,
        "new_chat_participant": {
          "id": 5578332030,
          "is_bot": true,
          "first_name": "ЕМДС",
          "username": "ris_emds_bot"
        },
        "new_chat_member": {
          "id": 5578332030,
          "is_bot": true,
          "first_name": "ЕМДС",
          "username": "ris_emds_bot"
        },
        "new_chat_members": [
          {
            "id": 5578332030,
            "is_bot": true,
            "first_name": "ЕМДС",
            "username": "ris_emds_bot"
          }
        ]
      }
    }
  ]
}
```

http://10.3.124.168:3000/actuator/health

# Создание бота

Done! Congratulations on your new bot. You will find it at t.me/ris_emds_bot.
You can now add a description, about section and profile picture for your bot,
see /help for a list of commands.
By the way, when you've finished creating your cool bot,
ping our Bot Support if you want a better username for it.
Just make sure the bot is fully operational before you do this.

Use this token to access the HTTP API:
5578332030:AAEcnkr-SQnuZhoOFD-s6uZMVLy0NC_BY1A

https://api.telegram.org/bot5578332030:AAEcnkr-SQnuZhoOFD-s6uZMVLy0NC_BY1A/getMe

```json
{
  "ok": true,
  "result": {
    "id": 5578332030,
    "is_bot": true,
    "first_name": "ЕМДС",
    "username": "ris_emds_bot",
    "can_join_groups": true,
    "can_read_all_group_messages": false,
    "supports_inline_queries": false
  }
}
```
