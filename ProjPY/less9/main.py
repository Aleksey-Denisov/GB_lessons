#Написать простой парсер для извлечения информации с любого сайта.
#Например - новость, или погоду с сайта mail.ru
from bs4 import BeautifulSoup
import requests
while True:
    try:
        #не смог придумать как лучше будет запросить города, по этому надо знать что писать например sankt_peterburg
        #или ничего не писать и будет температура в Москве
        city = input("Введите название города: ")
        if city == "":
            city = 'moskva'
        url = f'https://pogoda.mail.ru/prognoz/{city}'
        resp = requests.get(url).text
        soup = BeautifulSoup(resp, 'html.parser')
        place = soup.find('h1', class_='information__header__left__place__city').get_text(strip=True)
        timer = soup.find('div', class_='information__header__left__date').get_text(strip=True)
        temp = soup.find('div', class_='information__content__temperature').get_text(strip=True)
        print(f"{place}: {temp}")
        print(f"{timer}")
        break
    except:
        print("Не знает такого города, если ничего не указывать по умолчанию будет Москва")