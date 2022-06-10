# The Countdown Bot for Telegram

Could be used for calculating time for future events.

## Environment:
  Could be run in a docker container. Requires a running RDBMS(postgers)
## Required properties:
-   telegram.bot.token=${TELEGRAM_TOKEN}
-   spring.datasource.url=${POSTGRES_URL}
-   spring.datasource.username=${POSTGRES_USER}
-   spring.datasource.password=${POSTGRES_PASSWORD}

## Commands
- **/new**
<br> Creates a new countdown.
Example: \new somecountdown 21/12/2029 00:00:00 GMT+3:00
- **/check**
<br> Prints the remaining time for the alredy created countdown.
Example:
- /check somecountdown

## Deployed bot: @Wombats_countdow_bot

## Docker image: artyompanfutov/countdown-telegram-bot:0.0.1

