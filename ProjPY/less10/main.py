
from telegram import Update, Bot, InlineKeyboardButton, InlineKeyboardMarkup
from telegram.ext import Updater, CommandHandler, MessageHandler, Filters, CallbackQueryHandler
from credits import bot_tg
from bs4 import BeautifulSoup
import requests

bot = Bot(bot_tg)
updater = Updater(bot_tg, use_context=True)
dispatcher = updater.dispatcher

def start(update, context):
    context.bot.send_message(update.effective_chat.id, "Привет, предлагаю тебе получить информацию")
    context.bot.send_message(update.effective_chat.id, "Чтобы увидеть текущую погоду в своем городе напиши\n"
                                                       "'погода-твой-город'")
def getTemp(mes):
    res = mes.split()
    res = ''.join(res)
    url = f'https://sinoptik.ua/{res}'
    resp = requests.get(url).text
    soup = BeautifulSoup(resp, 'html.parser')
    try:
        curRegion = soup.find('div', class_='currentRegion').get_text(strip=True)
        desc = soup.find('div', class_='description').get_text(strip=True)
        temp = soup.find('p', class_='today-temp').get_text(strip=True)
        return f"{curRegion}\nТемпература воздуха сейчас {temp}\n{desc}"
    except:
        return "Не знает такого города"
def message(update, context):
    str1 = "погода"
    mes = update.message.text
    if mes.startswith(str1):
        context.bot.send_message(update.effective_chat.id, getTemp(mes))
    else:
        context.bot.send_message(update.effective_chat.id, "Я пока не знаю что добавить к этому")
def unknow_command(update, context):
    context.bot.send_message(update.effective_chat.id, "Не знаю такой команды")

start_handler = CommandHandler('start', start)
unknow_handler = MessageHandler(Filters.command, unknow_command)
message_handler = MessageHandler(Filters.text, message)

dispatcher.add_handler(start_handler)
dispatcher.add_handler(unknow_handler)
dispatcher.add_handler(message_handler)

updater.start_polling()
updater.idle()
