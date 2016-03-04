<!-- doc.py -->
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

Домашнее задание:
-----------------

Литература
----------
* Пакет java.io
* Потоки выполнения. Синхронизация.

....
...
throw ex;
ex.printStackTrace();
....
...
[01_Exceptions/src/test/java/Exceptions.java](01_Exceptions/src/test/java/Exceptions.java)



Вставляем подстроку в позицию 13
Удаляем кусок
Цепочка действий
[02_StringBuilder/src/test/java/StringBuilderTest.java](02_StringBuilder/src/test/java/StringBuilderTest.java)

File f1 = new File(STRING_FILENAME);
[02_StringBuilder/src/test/java/StringsTest.java](02_StringBuilder/src/test/java/StringsTest.java)

Обновляем
[03_SaveToFile/src/test/java/FileStorageTest.java](03_SaveToFile/src/test/java/FileStorageTest.java)

Считываем обратно
[03_SaveToFile/src/test/java/MyClassXMLTest.java](03_SaveToFile/src/test/java/MyClassXMLTest.java)

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
[04_ProblemFileWriteRead/src/main/java/ObjectSaveLoad.java](04_ProblemFileWriteRead/src/main/java/ObjectSaveLoad.java)

Используйте: OutputStreamWriter
[04_ProblemFileWriteRead/src/main/java/TextSaveLoad.java](04_ProblemFileWriteRead/src/main/java/TextSaveLoad.java)

Вложенные классы в Java
-----------------------
Не можем менять локальных переменных
value++;
notFinal++; // Ошибка компиляции
Эта строка синтаксически корректна
При определении анонимного класса применен полиморфизм - переменная listener
содержит экземпляр анонимного класса, реализующего существующий
интерфейс ActionListener
int getOuterField() {
return OuterClass.this.outerField; // Эта строка кода - ошибка компиляции
}
LocalInnerClass inner; // Ошибка компиляции: локальные классы тут не видны
[05_JavaInnerClasses/src/main/java/OuterClass.java](05_JavaInnerClasses/src/main/java/OuterClass.java)

Анонимный класс
``` java
        MyInterface myInterface = new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println("InnerClassTest.myMethod");
            }
        };

        myInterface.myMethod();
```

[05_JavaInnerClasses/src/test/java/InnerClassTest.java](05_JavaInnerClasses/src/test/java/InnerClassTest.java)

``` java
@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        // Добавляем аттрибут ${message} для hello.jsp
        model.addAttribute("message", "Добро пожаловать на наш сайт!");
        model.addAttribute("a", 2);
        model.addAttribute("b", 12);
        return "hello";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model, @RequestParam("a") int a,
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
    public String printMulTable2(Model model, @PathVariable("size") Integer size) {
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

        //return back to index.jsp
        ModelAndView model = new ModelAndView("list");
        model.addObject("lists", list);

        return model;
    }
}
```

[SpringMVC/src/main/java/ru/levelp/mvc/controller/HelloController.java](SpringMVC/src/main/java/ru/levelp/mvc/controller/HelloController.java)

resume.setName("Нужное нам резюме: " + query);
[SpringMVC/src/main/java/ru/levelp/mvc/controller/ResumeController.java](SpringMVC/src/main/java/ru/levelp/mvc/controller/ResumeController.java)

Сравнение с игнорированием
[SpringMVC/src/main/java/ru/levelp/mvc/storage/FileStorage.java](SpringMVC/src/main/java/ru/levelp/mvc/storage/FileStorage.java)

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
[SpringMVC/src/test/java/jdbc/PostgresJDBC.java](SpringMVC/src/test/java/jdbc/PostgresJDBC.java)

@Test
public void
[SpringMVC/src/test/java/ru/levelp/mvc/UserTest.java](SpringMVC/src/test/java/ru/levelp/mvc/UserTest.java)

Домашнее задание
----------------

Проект: https://github.com/levelp/WebInterface

Сделать вывод всех сообщений об ошибках.
Вывод процесса решения уравнения в формате
HTML.

http://htmlbook.ru - справочник по HTML.


