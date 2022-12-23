# Будем делать ежедневник
from datetime import date
from calendar import monthrange
import os.path
import datetime
def main():
    current_datetime = date.today()
    while True:
        print(f"Сегодня {current_datetime}, чем я могу вам помочь?")
        print(f"1 Посмотреть события на сегодня")
        print(f"2 Посмотреть события на месяц")
        print(f"3 Внести изменения/добавить события в расписание")
        print(f"4 Запланировать следующий месяц и внести изменения")
        print(f"5 Завершить работу")
        ans = inputAns(6)
        if ans == 1:
            printEvent(current_datetime, ans)
        elif ans == 2:
            printEvent(current_datetime, ans)
        elif ans == 3:
            printEvent(current_datetime, ans)
            writeEvent(current_datetime)
        elif ans == 4:
            newdate = inputMounth()
            printEvent(newdate, ans)
            writeEvent(newdate)
        elif ans == 5:
            break
def inputMounth():
    prov = False
    while not prov:
        try:
            x = int(input(f"Укажите месяц (от 1 до 12), в который будем вносить изменения: "))
            y = int(input(f"Укажите год (от 2022 до 2050), в который будем вносить изменения: "))
            if 0 < x <= 12 and 2021 < y <= 2050:
                dateUs = datetime.date(y, x, 1)
                prov = True
            else:
                print("Не понимаю, что вы хотите выбрать, попробуйте ещё раз")
        except ValueError:
            print("Не понимаю, что вы хотите выбрать, попробуйте ещё раз")
    return dateUs
def chooseDay(current_datetime):
    days = monthrange(current_datetime.year, current_datetime.month)[1]
    prov = False
    while not prov:
        try:
            x = int(input(f"Укажите день (от 1 до {days}), в который будем вносить изменения: "))
            if 0 < x <= days:
                prov = True
            else:
                print("Не понимаю, что вы хотите выбрать, попробуйте ещё раз")
        except ValueError:
            print("Не понимаю, что вы хотите выбрать, попробуйте ещё раз")
    return x-1
def changeEvent(eventDay, val, day):
    if val == 1:
        res = ""
        for i in range(len(eventDay)):
            if eventDay[i] != "\n":
                res += eventDay[i]
        userData = input("Укажите событие:")
        res += " " + userData + ";\n"
    else:
        res = ""
        sp = []
        index = 0
        for i in range(len(eventDay)):
            if eventDay[i] == " " and index == 0:
                index = 1
            elif eventDay[i] != ";" and index > 0:
                res += eventDay[i]
            elif eventDay[i] == ";" and index > 0:
                index = 0
                sp.append(res)
                res = ""
        if len(sp) > 0:
            print("Необходимо выбрать событие для изменения")
            ans = inputAns(len(sp)+1)
            if val == 2:
                userData = input("Укажите событие:")
                sp[ans - 1] = userData
            elif val == 3:
                sp[ans - 1] = ""
            res = str(day + 1)
            for i in range(len(sp)):
                if sp[i] == "":
                    continue
                res += " " + sp[i] + ";"
            res += "\n"
        else:
            print("Нет событий для изменения")
            res = eventDay
    return res
def writeEvent(current_datetime):
    my_file = open(f"diary_{current_datetime.month}_{current_datetime.year}.txt", "r")
    temp = my_file.readlines()
    my_file.close()
    choose = chooseDay(current_datetime)
    while True:
        print("Выберите операцию:")
        print("1 Добавить событие")
        print("2 Изменить событие")
        print("3 Удалить событие")
        print("4 Выбрвть другой день")
        print("5 Посмотреть все изменения")
        print("6 Закончить и сохранить изменения")
        print("7 Закончить без изменений")
        ans = inputAns(8)
        if ans == 1:
            temp[choose] = changeEvent(temp[choose], ans, choose)
            print(temp[choose])
        elif ans == 2:
            print(temp[choose])
            temp[choose] = changeEvent(temp[choose], ans, choose)
            print(temp[choose])
        elif ans == 3:
            print(temp[choose])
            temp[choose] = changeEvent(temp[choose], ans, choose)
            print(temp[choose])
        elif ans == 4:
            choose = chooseDay(current_datetime)
        elif ans == 5:
            for line in temp:
                res = ""
                for i in range(len(line)):
                    if line[i] != "\n":
                        res += line[i]
                print(res)
        elif ans == 6:
            my_file = open(f"diary_{current_datetime.month}_{current_datetime.year}.txt", "w+")
            my_file.writelines(temp)
            my_file.close()
            break
        elif ans == 7:
            break
def printEvent(current_datetime, ans):
    check_file = os.path.exists(f"diary_{current_datetime.month}_{current_datetime.year}.txt")
    if check_file == False:
        print("Такого файла не существует, создаю новый")
        my_file = open(f"diary_{current_datetime.month}_{current_datetime.year}.txt", "w+")
        days = monthrange(current_datetime.year, current_datetime.month)[1]
        for i in range(days):
            my_file.write(f"{i+1}\n")
        my_file.close()
    my_file = open(f"diary_{current_datetime.month}_{current_datetime.year}.txt", "r")
    index = 1
    for line in my_file:
        res = ""
        if index == current_datetime.day and ans == 1:
            for i in range(len(line)):
                if line[i] != "\n":
                    res += line[i]
            print(res)
        elif ans == 2 or ans == 3 or ans == 4:
            for i in range(len(line)):
                if line[i] != "\n":
                    res += line[i]
            print(res)
        index += 1
    my_file.close()
def inputAns(gr):
    prov = False
    while not prov:
        try:
            x = int(input(f"Укажите номер пункта, который вы хотите выбрать: "))
            if 0 < x < gr:
                prov = True
            else:
                print("Не понимаю, что вы хотите выбрать, попробуйте ещё раз")
        except ValueError:
            print("Не понимаю, что вы хотите выбрать, попробуйте ещё раз")
    return x
main()