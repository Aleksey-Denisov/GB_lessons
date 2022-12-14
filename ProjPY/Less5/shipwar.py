import random
#Из-за возникшей проблемы с рандомными числами, количество кораблей уменьшено до 4х, но всегда можно сделать полный набор
def gamewar():
    #ships = [1, 1, 1, 1, 2, 2, 2, 3, 3, 4]
    ships = [1, 2, 3, 4]
    playerpos = 'Player'
    a = [[0] * 10 for i in range(10)]
    b = [[0] * 10 for i in range(10)]
    com = inputComp(b, ships)
    pl = inputPlayer(a, ships)
    while True:
        if playerpos == 'Player':
            print("Ход игрока")
            shotShip(com)
            if checkWin(pl) == True:
                return
            playerpos = 'Comp'
        else:
            print("Ход компа")
            shotShipCom(pl)
            if checkWin(pl) == True:
                return
            playerpos = 'Player'
def poleCom(b):
    x = b
    for i in range(len(x)):
        for j in range(len(x[i])):
            if x[j][i] != "X" and x[j][i] != "*":
                if x[j][i] > 0:
                    x[j][i] = 0
        print(x[i])
def checkWin(a):
    for i in range(len(a)):
        for j in range(len(a[i])):
            if a[j][i] != "X" and a[j][i] != "*":
                if a[j][i] > 0:
                    return False
    return True
def shotShip(pl):
    prov = False
    while not prov:
        try:
            pole(pl)
            x = (int(input(f"Введите первую координату по X куда будем стрелять: ")))
            y = (int(input(f"Введите вторую координату по Y куда будем стрелять: ")))
            if 0 <= x <= 9 and 0 <= y <= 9:
                if pl[y][x] != "X" and pl[y][x] != "*":
                    if pl[y][x] > 0:
                        pl[y][x] = 'X'
                        print("Попадание в вражеский корабль")
                    elif pl[y][x] == 0:
                        pl[y][x] = '*'
                        print("Промах")
                        prov = True
                else:
                    print("Вы уже стреляли в эту позицию")
                if checkWin(pl) == True:
                    print("Вы выиграли")
                    return
            else:
                print(f"Ошибка ввода")
        except ValueError:
            print(f"Ошибка ввода")
    return pl
def shotShipCom(com):
    x = (int(random.randint(10, 99) / 10))
    y = (int(random.randint(10, 99) / 10))
    prov = False
    while not prov:
        if com[y][x] != "X" and com[y][x] != "*":
            if com[y][x] > 0:
                com[y][x] = 'X'
                print("Попадание в вражеский корабль")
            elif com[y][x] == 0:
                com[y][x] = '*'
                print("Промах")
                prov = True
            if checkWin(com) == True:
                print("Выиграл компьютер")
                return
        else:
            if y == 9 and x == 9:
                x = 0
                y = 0
            elif x < 9:
                x += 1
            elif x == 9 and y < 9:
                y += 1
                x = 0
    pole(com)
    return com
def inputPlayer(a,ships):
    for i in range(len(ships)):
        prov = False
        while not prov:
            p = inputval(ships[i])
            if a[p[1]][p[0]] == 0 and ships[i] == 1:
                a[p[1]][p[0]] = ships[i]
                pole(a)
                prov = True
            elif a[p[1]][p[0]] == 0 and ships[i] > 1:
                er = []
                index = 0
                for j in range(ships[i]):
                    if p[2] == 'g' and a[p[1]][p[0]] == 0 and j < (ships[i] - 1):
                        er.append(p[0])
                        index += 1
                        p[0] += 1
                    elif p[2] == 'v' and a[p[1]][p[0]] == 0 and j < (ships[i] - 1):
                        er.append(p[1])
                        index += 1
                        p[1] += 1
                    elif p[2] == 'g' and j == (ships[i] - 1) and a[p[1]][p[0]] == 0:
                        er.append(p[0])
                        index += 1
                        prov = True
                    elif p[2] == 'v' and j == (ships[i] - 1) and a[p[1]][p[0]] == 0:
                        er.append(p[1])
                        index += 1
                        prov = True
                    else:
                        print('Тут уже размещен корабль')
                        break
                if len(er) > 1:
                    for j in range(index):
                        if p[2] == 'g':
                            a[p[1]][er[j]] = ships[i]
                        elif p[2] == 'v':
                            a[er[j]][p[0]] = ships[i]
                pole(a)
            else:
                print('Тут уже размещен корабль')
    return a
def inputComp(b, ships):
    for i in range(len(ships)):
        prov = False
        while not prov:
            p = []
            x=10
            if ships[i] == 1:
                p.append(int(random.randint(10,99)/x))
                p.append(int(random.randint(10,99)/x))
                prov = True
            elif ships[i] > 1:
                p.append(int(random.randint(10,99)/x))
                p.append(int(random.randint(10,99)/x))
                p.append(int(random.random()))
                if p[2] == 0 and p[1] + ships[i] <= 10:
                    prov = True
                elif p[2] == 1 and p[0] + ships[i] <= 10:
                    prov = True
        prov = False
        while not prov:
            print(p, ships[i])
            if b[p[0]][p[1]] == 0 and ships[i] == 1:
               b[p[0]][p[1]] = ships[i]
               prov = True
            elif b[p[0]][p[1]] == 0 and ships[i] > 1:
               er = []
               index = 0
               for j in range(ships[i]):
                    if p[2] == 0 and b[p[0]][p[1]] == 0 and j < (ships[i] - 1):
                        er.append(p[1])
                        index += 1
                        p[1] += 1
                    elif p[2] == 1 and b[p[0]][p[1]] == 0 and j < (ships[i] - 1):
                        er.append(p[0])
                        index += 1
                        p[0] += 1
                    elif p[2] == 0 and j == (ships[i] - 1) and b[p[0]][p[1]] == 0:
                        er.append(p[1])
                        index += 1
                        prov = True
                    elif p[2] == 1 and j == (ships[i] - 1) and b[p[0]][p[1]] == 0:
                        er.append(p[0])
                        index += 1
                        prov = True
               if len(er) > 1:
                    for j in range(index):
                        if p[2] == 0:
                            b[p[0]][er[j]] = ships[i]
                        elif p[2] == 1:
                            b[er[j]][p[1]] = ships[i]
    return b
def inputval(ship):
    p = []
    prov = False
    while not prov:
        try:
            p = []
            if ship == 1:
                p.append(int(input(f"Введите первую координату размещения {ship}-палубного корабля X: ")))
                p.append(int(input(f"Введите вторую координату размещения {ship}-палубного корабля Y: ")))
                p.append("")
                if 0 <= p[0] <= 9 and 0 <= p[1] <= 9:
                    prov = True
                else:
                    print(f"Ошибка расположения корабля")
            elif ship > 1:
                p.append(int(input(f"Введите первую координату размещения {ship}-палубного корабля X: ")))
                p.append(int(input(f"Введите вторую координату размещения {ship}-палубного корабля Y: ")))
                p.append(input(f"Определим расположение {ship}-палубного корабля ввести g или v: "))
                if p[2] == 'g' and p[0]+ship <= 10:
                    prov = True
                elif p[2] == 'v' and p[1]+ship <= 10:
                    prov = True
                elif p[0]<0 or p[1]<0:
                    print(f"Ошибка расположения корабля")
                else:
                    print(f"Ошибка расположения корабля")
        except ValueError:
            print(f"Ошибка расположения корабля")

    return p
def pole(a):
    for i in range(10):
        print(a[i])