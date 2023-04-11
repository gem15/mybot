# Getting Started
## EMDS
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
[Минимальный «hello world» telegram-бот](https://habr.com/ru/articles/306222/)
https://api.telegram.org/bot5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA/getUpdates
```json
{
  "ok": true,
  "result": [
    {
      "update_id": 8520078,
      "message": {
        "message_id": 168,
        "from": {
          "id": 827188983,
          "is_bot": false,
          "first_name": "Геннадий",
          "last_name": "Манн",
          "username": "gemnnn",
          "language_code": "ru"
        },
        "chat": {
          "id": 827188983,
          "first_name": "Геннадий",
          "last_name": "Манн",
          "username": "gemnnn",
          "type": "private"
        },
        "date": 1681116912,
        "text": "привет"
      }
    }
  ]
}
```
https://api.telegram.org/bot5359291436:AAF8sqgGVIVG5mGTjg3aJ25u2KvehoFxuIA/sendMessage?chat_id=827188983&text=Привет%20мир

```json
{
    "ok": true,
    "result": {
        "message_id": 170,
        "from": {
            "id": 5359291436,
            "is_bot": true,
            "first_name": "💎gem",
            "username": "gnustopal_bot"
        },
        "chat": {
            "id": 827188983,
            "first_name": "Геннадий",
            "last_name": "Манн",
            "username": "gemnnn",
            "type": "private"
        },
        "date": 1681117929,
        "text": "Привет мир"
    }
}
```
```json
{
    "ok": true,
    "result": {
        "file_id": "BQACAgIAAxkBAAOtZDQkeLAeqBE4NUIWfRC11ICOXCoAAvkpAAJqUaBJkh6szfMdnyMvBA",
        "file_unique_id": "AgAD-SkAAmpRoEk",
        "file_size": 228,
        "file_path": "documents/file_0.json"
    }
}
```