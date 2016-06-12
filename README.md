.\00_README.md


﻿Тонкости Java. Ввод/вывод. Параллельное выполнение
==================================================

Операторы и структура кода. Исключения
--------------------------------------

Исключения
----------

Маленькие хитрости Java. StringBuilder
--------------------------------------
Тест производительности.

Файловая система. Ввод-вывод
----------------------------
File
Scanner

Начало реализации DAO - хранение в файлах
-----------------------------------------

Модульное тестирование JUnit 4 - разобрали


Работа с PostgreSQL
-------------------


SELECT
------

``` SQL

```

INSERT
------
``` SQL

```


UPDATE
------
``` SQL

```


DELETE
------
``` SQL

```


CREATE TABLE
------------
``` SQL

```

Литература
----------
* Пакет java.io
* Потоки выполнения. Синхронизация.

.\01_Exceptions\00_intro.md


Исключения
----------

* RuntimeException
* Exception

.\01_Exceptions\README.md


<!-- doc.py -->
Объявление своего класса-исключения
``` java
public class MyException extends Exception {
    // Могут быть поля-значения
    final double d;
    final String name;
    final int i;

    // Конструктор
    public MyException(String name, int i, double d) {
        super();
        this.name = name;
        this.i = i;
        this.d = d;
    }
}
```

[src/main/java/MyException.java](src/main/java/MyException.java)

....
...
throw ex;
ex.printStackTrace();
....
...
[src/test/java/Exceptions.java](src/test/java/Exceptions.java)


.\01_Exceptions\pom.xml

.\01_Exceptions\src\main\java\ExceptionDemo.java

System.setOut(new PrintStream("my.log"));
throw new MyRuntimeException("xx", 2, 1);
InvalidArgumentException(new String[]{"i == 0"});
.\01_Exceptions\src\main\java\MyException.java

Объявление своего класса-исключения
``` java
public class MyException extends Exception {
    // Могут быть поля-значения
    final double d;
    final String name;
    final int i;

    // Конструктор
    public MyException(String name, int i, double d) {
        super();
        this.name = name;
        this.i = i;
        this.d = d;
    }
}
```
.\01_Exceptions\src\main\java\MyRuntimeException.java

.\01_Exceptions\src\main\java\RuntimeExceptionDemo.java

.\01_Exceptions\src\test\java\DivideByZero.java

.\01_Exceptions\src\test\java\Exceptions.java

/....
...
throw ex;
ex.printStackTrace();
/....
...
.\02_StringBuilder\README.md


<!-- doc.py -->
XXX


Вставляем подстроку в позицию 13
Удаляем кусок
Цепочка действий
[src/test/java/StringBuilderTest.java](src/test/java/StringBuilderTest.java)

File f1 = new File(STRING_FILENAME);
[src/test/java/StringsTest.java](src/test/java/StringsTest.java)


.\02_StringBuilder\pom.xml

.\02_StringBuilder\src\main\java\Point.java

.\02_StringBuilder\src\test\java\StringBuilderTest.java

Вставляем подстроку в позицию 13
Удаляем кусок
Цепочка действий
.\02_StringBuilder\src\test\java\StringVsStringBuilder.java

Результат для строки
Результат для StringBuilder
Результат для StringBuffer
@Ignore
Runtime.getRuntime().gc();
Runtime.getRuntime().gc();
.\02_StringBuilder\src\test\java\StringsTest.java

File f1 = new File(STRING_FILENAME);
.\03_SaveToFile\README.md


<!-- doc.py -->
XXX
Обновляем
[src/test/java/FileStorageTest.java](src/test/java/FileStorageTest.java)

Считываем обратно
[src/test/java/MyClassXMLTest.java](src/test/java/MyClassXMLTest.java)


.\03_SaveToFile\pom.xml

.\03_SaveToFile\src\main\java\MyClassHelper.java

.\03_SaveToFile\src\main\java\Person.java

.\03_SaveToFile\src\main\java\dao\Entity.java

.\03_SaveToFile\src\main\java\dao\FileStorage.java

.\03_SaveToFile\src\main\java\dao\Storage.java

.\03_SaveToFile\src\main\java\dao\XMLFile.java

XMLDecoder - из текстового файла считывает XML
и заполняет поля объектов
Запись (сериализация) любого объекта в формат XML
.\03_SaveToFile\src\main\java\model\Resume.java

.\03_SaveToFile\src\test\java\FileStorageTest.java

Обновляем
.\03_SaveToFile\src\test\java\MyClassXMLTest.java

f1.setFinalField(343);
Считываем обратно
.\03_SaveToFile\src\test\java\TextFileSaveLoad.java

Запись в текстовый файл
Чтение из текстового файла
Считываем элементы массива
.\03_SaveToFile\src\test\java\UserSaveLoadTest.java

TODO: завершить пример
.\03_SaveToFile\src\test\java\XMLSerialize.java

.\04_ProblemFileWriteRead\README.md


<!-- doc.py -->
XXX
Используйте: OutputStreamWriter
Через Reflection API получаем класс
Через Reflection API получаем список полей
Получаем значение поля
Закрываем файл
Имя класса
Загружаем класс по имени
Создаём экземпляр класса
Pattern hh = Pattern.compile("(\\w+):");
Пропускаем "="
[src/main/java/ObjectSaveLoad.java](src/main/java/ObjectSaveLoad.java)

Используйте: OutputStreamWriter
[src/main/java/TextSaveLoad.java](src/main/java/TextSaveLoad.java)


.\04_ProblemFileWriteRead\pom.xml

.\04_ProblemFileWriteRead\src\main\java\MyClass.java

.\04_ProblemFileWriteRead\src\main\java\ObjectSaveLoad.java

Используйте: OutputStreamWriter
Через Reflection API получаем класс
Через Reflection API получаем список полей
Получаем значение поля
Закрываем файл
Имя класса
Загружаем класс по имени
Создаём экземпляр класса
Pattern hh = Pattern.compile("(\\w+):");
Пропускаем "="
.\04_ProblemFileWriteRead\src\main\java\TextSaveLoad.java

Используйте: OutputStreamWriter
.\04_ProblemFileWriteRead\src\test\java\SaveLoadText.java

.\04_ProblemFileWriteRead\src\test\java\TextSaveLoadTest.java

.\05_JavaInnerClasses\README.md


Внутренние классы Java
======================

Внутри классов Java можно объявять вложенные (внутренние классы).

Они бывают 3-х видов:
 * Статический внутренний класс (с ключевым словом static)
 * Внутренние классы - объявляются внутри основного класса (без слова static)
 * Анонимные (безымянные) классы - объявляются внутри методов основного класса

.\05_JavaInnerClasses\pom.xml

.\05_JavaInnerClasses\src\main\java\OutClass2.java

.\05_JavaInnerClasses\src\main\java\OuterClass.java

Вложенные классы в Java
-----------------------
Константа в локальном классе
static int staticVar = 100; // Ошибка компиляции
Не можем менять локальных переменных
value++;
notFinal++; // Ошибка компиляции
Эта строка синтаксически корректна
Можно создавать сколько угодно экземпляров локального класса
но только внутри данного метода
При определении анонимного класса применен полиморфизм - переменная listener
содержит экземпляр анонимного класса, реализующего существующий
интерфейс ActionListener
Начало анонимного локального класса >>>
<< Окончание
Не можем обращаться к обычным полям класса
int getOuterField() {
return OuterClass.this.outerField; // Эта строка кода - ошибка компиляции
}
LocalInnerClass inner; // Ошибка компиляции: локальные классы тут не видны
static void xx(){ // Ошибка
}
.\05_JavaInnerClasses\src\main\java\Stack.java

Помещаем новый элемент на вершину
Запоминаем значение
Переводим вершину стека на следующий элемент
Возвращаем значение
.\05_JavaInnerClasses\src\test\java\InnerClassTest.java

Анонимный класс
``` java
        MyInterface myInterface = new MyInterface() {
            @Override
            public void myMethod() {
                Assert.assertEquals(1, i);
                // i++; // Невозможно сделать
                System.out.println("InnerClassTest.myMethod");
            }
        };

        myInterface.myMethod();
```
.\05_JavaInnerClasses\src\test\java\StackTest.java

.\09_Java8\pom.xml

.\09_Java8\src\main\java\defaultimp\Circle.java

.\09_Java8\src\main\java\defaultimp\Shape.java

.\09_Java8\src\main\java\defaultimp\Square.java

.\09_Java8\src\main\java\lambda\LambdaDemo.java

.\09_Java8\src\main\java\lambda\Operation.java

.\09_Java8\src\main\java\lambda_tree\SearchTree.java

Ищем куда поставить новый элемент
Мы идём налево если новый элемент меньше текущего
Иначе (новый элемент => текущему) идём направо
.\09_Java8\src\test\java\ShapesTest.java

.\09_Java8\src\test\java\lambda_tree\SearchTreeTest.java

2
/   \
1    5
.\JDBC_Demo\pom.xml

.\JDBC_Demo\src\main\java\jdbcdemo\JDBCDemo.java

Соединение с БД
Создаём SQL-оператор
Получаем результаты
.\JDBC_Demo\src\main\java\jdbcdemo\StaticInit.java

.\SpringMVC\README.md


Spring MVC приложения в Intellj IDEA
------------------------------------

Документация по Spring Framework: https://spring.io/docs

* Использование циклов в JSP: <http://localhost:8080/list>
* Таблица умножения: <http://localhost:8080/table?size=22>

Настройка Tomcat
----------------

Добавить в раздел **tomcat-users** в **<tomcat>/conf/tomcat-users.xml**:

``` xml
  <role rolename="manager-gui"/>
  <user username="admin" password="123" roles="manager-gui"/>
```

Запускаем Tomcat:
* **catalina.bat run** для Windows
* **catalina.sh run** для Linux/Mac

Открываем: <http://localhost:8080/manager/html>

Вводим логин и пароль: admin / 123

В разделе **Deploy / WAR file to deploy** выбираем наш **war**-файл и нажимаем Deploy.


.\SpringMVC\pom.xml

.\SpringMVC\src\main\java\ru\levelp\beans\BeanExample.java

.\SpringMVC\src\main\java\ru\levelp\beans\MyBean.java

.\SpringMVC\src\main\java\ru\levelp\mvc\controller\HelloController.java

``` java
@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        // Добавляем аттрибут ${message} для hello.jsp
        model.addAttribute("message", "Добро пожаловать на наш сайт!");
        model.addAttribute("a", 2);
        model.addAttribute("b", 3);
        return "hello";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model,
                      @RequestParam("a") int a,
                      @RequestParam("b") int b) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("sum", a + b);
        return "add";
    }

    /**
     * http://localhost:8080/table - выведется таблица умножения
     * http://localhost:8080/table?size=5 - задаём размер
     */
    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String printMulTable(Model model, @RequestParam(value = "size", required = false) Integer size) {
        model.addAttribute("html", "This <b>is</b> <strike>HTML</strike> from controller!");
        // Размер таблицы по-умолчанию (значение по-умолчанию)
        if (size == null) {
            size = 10;
        }
        model.addAttribute("size", size);
        return "table";
    }

    /**
     * Вывод таблицы умножения
     * http://localhost:8080/table - выведется таблица умножения
     * size - размер таблицы
     */
    @RequestMapping(value = "/table/{size}", method = RequestMethod.GET)
    public String printMulTable2(Model model,
                                 @PathVariable("size") Integer size) {
        model.addAttribute("html", "size = " + size);
        model.addAttribute("size", size);
        return "table";
    }

    @RequestMapping(value = "/table/{op}/{size}", method = RequestMethod.GET)
    public String printOpTable(Model model,
                               @PathVariable("op") String op,
                               @PathVariable("size") Integer size) {
        model.addAttribute("html", "size = " + size);
        model.addAttribute("size", size);
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = i + 1;
                int y = j + 1;
                switch (op) {
                    case "sum":
                        result[i][j] = x + y;
                        break;
                    case "sub":
                        result[i][j] = x - y;
                        break;
                    case "mul":
                        result[i][j] = x * y;
                        break;
                }
            }
        }
        model.addAttribute("result", result);
        return "any_table";
    }

    /**
     * Вывод списка: Питерский метрополитен
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showList() {
        List<String> list = new ArrayList<String>();
        list.add("1. Красная - Кировско-Выборгская");
        list.add("2. Синяя");
        list.add("3. Зелёная");
        list.add("4. Оранжевая");
        list.add("5. Фиолетовая");

        // "list" - имя .jsp страницы => list.jsp
        ModelAndView model = new ModelAndView("list");
        model.addObject("lists", list);

        return model;
    }
}
```
.\SpringMVC\src\main\java\ru\levelp\mvc\controller\ResumeController.java

resume.setName("Нужное нам резюме: " + query);
.\SpringMVC\src\main\java\ru\levelp\mvc\controller\UserController.java

.\SpringMVC\src\main\java\ru\levelp\mvc\forms\LoginForm.java

.\SpringMVC\src\main\java\ru\levelp\mvc\model\Name.java

.\SpringMVC\src\main\java\ru\levelp\mvc\model\Resume.java

.\SpringMVC\src\main\java\ru\levelp\mvc\model\User.java

.\SpringMVC\src\main\java\ru\levelp\mvc\storage\FileStorage.java

Сравнение с игнорированием
.\SpringMVC\src\main\java\servlets\MyServlet.java

.\SpringMVC\src\test\java\jdbc\PostgresJDBC.java

Создаём запрос
Набор результатов
Пока есть результаты
class Contact {
int id;
String name;
String surname;
}
query.executeUpdate("UPDATE contact SET ... WHERE ...");
query.executeUpdate("DELETE FROM contact WHERE ...");
query.executeUpdate("INSERT INTO contact VALUES(...)")
query.execute("CREATE TABLE ...");
.\SpringMVC\src\test\java\jdbc\SQLiteJDBC.java

.\SpringMVC\src\test\java\ru\levelp\mvc\AppTests.java

.\SpringMVC\src\test\java\ru\levelp\mvc\FileStorageTest.java

.\SpringMVC\src\test\java\ru\levelp\mvc\UserTest.java

@Test
public void
.\homework.md


Домашнее задание
================

Проект: https://github.com/levelp/WebInterface

Сделать вывод всех сообщений об ошибках.
Вывод процесса решения уравнения в формате
HTML.

http://htmlbook.ru - справочник по HTML.

.\pom.xml

.\pres\ex.java

.\themes.md


## ﻿Тонкости Java. Ввод/вывод. Параллельное выполнение
* Операторы и структура кода. Исключения
* Исключения
* Маленькие хитрости Java. StringBuilder
* Файловая система. Ввод-вывод
* Начало реализации DAO - хранение в файлах
* Домашнее задание:
* Литература
* Вложенные классы в Java
* Домашнее задание

