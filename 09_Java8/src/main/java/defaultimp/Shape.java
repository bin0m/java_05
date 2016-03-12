package defaultimp;

public interface Shape {

    String getName();

    /**
     * Метод presentation() c реализацией по-умолчанию
     *
     * @return строчку об объекте для вывода пользователю
     */
    default String presentation() {
        return "Presentation: " + getName();
    }
}