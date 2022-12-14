from shipwar import gamewar
gamewar()
# Игра в крестики нолики
def inputVal(player):
    prov = False
    while not prov:
        try:
            x = int(input(f"Введите номер поля в которых хотите устновить {player} от 1 до 9:"))
            if 1 <= x <= 9:
                prov=True
            else:
                print("Вы ввели неверную позицию, попробуйте ещё раз")
        except ValueError:
            print("Вы ввели неверную позицию, попробуйте ещё раз")
    return x-1
def krestnol():
    a = [" " for i in range(9)]
    playerpos = {'X': [], 'O': []}
    player = 'X'
    while True:
        print(f"Ход игрока {player}")
        drawGame(a)
        prov = False
        while not prov:
            temp = inputVal(player)
            if a[temp] == " ":
                a[temp] = player
                playerpos[player].append(temp)
                prov = True
            else:
                print("Это место уже занято, выберите другое")
        if check_Victory(player, playerpos):
            print(f"Выиграл игрок играющий {player}")
            drawGame(a)
            return
        if check_Tie(playerpos):
            print("Ничья")
            drawGame(a)
            return
        if player == 'X':
            player = 'O'
        else:
            player = 'X'
def check_Victory(player, playerpos):
    solution = [[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]
    for i in solution:
        if all(j in playerpos[player] for j in i):
            return True
    return False
def check_Tie(playerpos):
    if len(playerpos['X']) + len(playerpos['O']) == 9:
        return True
    return False
def drawGame(x):
    print(f"{x[0]}|{x[1]}|{x[2]}")
    print(f"_|_|_")
    print(f"{x[3]}|{x[4]}|{x[5]}")
    print(f"_|_|_")
    print(f"{x[6]}|{x[7]}|{x[8]}")
#krestnol()

