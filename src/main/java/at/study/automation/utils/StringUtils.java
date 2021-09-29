package at.study.automation.utils;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * Класс для генерации строк
 */
public class StringUtils {

    private static final String LATIN_PATTERN = "abcdefghijklmnoprstuvwxyxz";
    private static final String HEX_PATTERN = "1234567890abcdef";
    private static final Random RANDOM = new Random();

    /**
     * генерирует случайный емейл
     *
     * @return строку содержая случайный email
     */
    public static String randomEmail() {
        return randomString(LATIN_PATTERN, 3) + "@" + randomEnglishString(6) + "." + randomEnglishString(2);
    }

    /**
     * возвращает случайный набор символов
     *
     * @return строка содержащая английский
     */
    public static String randomEnglishString(int length) {
        return randomString(LATIN_PATTERN, length);
    }

    public static String randomHexString(int length) {
        return randomString(HEX_PATTERN, length);
    }

    /**
     * генерирунт случайную строку из передаваемого паттерна заданной длины
     *
     * @return сгенерированная строка
     */
    public static String randomString(String pattern, int lengtth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lengtth; i++) {
            int patternLenght = pattern.length();
            int randomIndex = RANDOM.nextInt(patternLenght);
            char c = pattern.charAt(randomIndex);
            sb.append(c);
        }
        return sb.toString();
    }

    @Test
    public void randomStringTest() {

        System.out.println(randomEmail());
        System.out.println(randomEnglishString(10));
        System.out.println(randomString("SASA", 10));

    }

}
