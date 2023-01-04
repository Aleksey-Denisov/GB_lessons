#Написать программу, где создадим класс Soup (для определения типа супа), принимающий 1 аргумент - который отвечает за основной продукт к выбираемому супу.
#В этом классе создать метод show_my_soup(), выводящий на печать «Суп - {Основной продукт}» в случае наличия добавки
#Это как доп к этой задаче - иначе отобразится следующая фраза: «Обычный кипяток»
#Честно говоря не совсем понял смысл задания, по этому как получилось
class Soup:
    def __init__(self, ing):
        self.ing = ing
    def show_my_soup(self):
        if self.ing == "капуста":
            soup = "Щи"
        elif self.ing == "свекла":
            soup = "Борщ"
        elif self.ing == "колбаса":
            soup = "Солянка"
        elif self.ing == "консервы":
            soup = "Консервный"
        elif self.ing != "":
            soup = self.ing
        elif self.ing == "":
            print("Обычный кипяток")
            return
        print(f"Суп - {soup}")
def soupPtint():
    sol = Soup(input("Ведите основной продукт для супа: "))
    sol.show_my_soup()
#2)Нужно напистаь программу
#В ней используем классы - имя студента name, номер группы group и список полученных оценок progress.
#В самой программе вводим список всех студентов.
#В программе нужно вывести список студентов, отсортированный по имени, А так же студентов, у которых низкие оценки
class Student:
    def __init__(self):
        self.progress = []
        self.res = 0
        self.enterName()
        self.enterGroup()
        self.enterProgress()
    def enterName(self):
        self.name = input("Введите имя студента: ")
    def enterGroup(self):
        while True:
            try:
                self.group = int(input("Введите номер группы: "))
                break
            except ValueError:
                print("Ошибка ввода")
    def enterProgress(self):
        while True:
            try:
                val = int(input("Введите количество вводимых оценок: "))
                for i in range(val):
                    self.progress.append(int(input("Введите оценку: ")))
                break
            except ValueError:
                print("Ошибка ввода")
        self.middleProgress()
    def middleProgress(self):
        for i in range(len(self.progress)):
            self.res += self.progress[i]
        self.res /= len(self.progress)
    def printSt(self):
        print(self.name, self.group, self.res)
class ListStudents:
    def __init__(self):
        self.listSt = []
        self.enterListStudent()
        self.sortName()
    def enterListStudent(self):
        while True:
            try:
                val = int(input("Введите количество вводимых данных: "))
                for i in range(val):
                    self.listSt.append(Student())
                break
            except ValueError:
                print("Ошибка ввода")
    def sortName(self):
        self.listSt.sort(key=lambda x: (x.name, x.res))
        for i in range(len(self.listSt)):
            self.listSt[i].printSt()
def stPr():
    l = ListStudents()
soupPtint()
stPr()
