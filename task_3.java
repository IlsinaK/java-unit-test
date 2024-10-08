import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class) // Аннотация для параметризованных тестов
public class CheckIsAdultTest {

    private final int age;
    private final boolean expectedResult;

    // Инициализация полей класса в конструкторе
    public CheckIsAdultTest(int age, boolean expectedResult) {
        this.age = age;
        this.expectedResult = expectedResult;
    }

    // Метод, помеченный аннотацией для параметров теста
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            {17, false}, // Меньше 18 - несовершеннолетний
            {18, true},  // Ровно 18 - совершеннолетний
            {19, true},  // Больше 18 - совершеннолетний
            {21, true}   // В некоторых странах совершеннолетие с 21 года
        };
    }

    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Program program = new Program();
        boolean isAdult = program.checkIsAdult(age); // Передаем возраст пользователя
        // Сравниваем полученный и ожидаемый результаты
        assertEquals("Некорректный статус совершеннолетия для возраста: " + age, expectedResult, isAdult);
    }
}
