class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.allowed = True

    def allowedHere(self, yOrN):
        self.allowed = yOrN


class Parent(Person):
    def __init__(self, name, children, isTeacher):
        super().__init__(name, 99)
        self.children = children
        self.isTeacher = isTeacher


class Student(Person):
    def __init__(self, name, age, isPalyStudent, grade, GPA, id):
        self.palyStudent = isPalyStudent
        self.grade = grade
        self.GPA = GPA
        self.id = id
        super().__init__(name, age)

    def updateGPA(self, new):
        self.GPA = new

    def getGPA(self):
        return self.GPA


class CSstudent(Student):
    def __init__(self, name, age, isPalyStudent, grade, studentNum, earnings):
        self.earnings = earnings
        super().__init__(name, age, isPalyStudent, grade, 6, studentNum)

    def updateEarning(self, new):
        self.earnings = new


davidZ = CSstudent("David Zou", 14, True, 9, 95069420)
