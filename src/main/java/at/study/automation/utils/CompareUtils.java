package at.study.automation.utils;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareUtils {

    public static void assertListSortedByDateDesc(List<String> dates) {
        List<String> datesCopy = new ArrayList<>(dates);
        datesCopy.sort(DATE_DESC_COMPARATOR);
        Assert.assertEquals(dates, datesCopy);
    }

    public static void assertListSortedByDateAsc(List<String> dates) {
        List<String> datesCopy = new ArrayList<>(dates);
        datesCopy.sort(DATE_ASC_COMPARATOR);
        Assert.assertEquals(dates, datesCopy);
    }

    private static final Comparator<String> DATE_DESC_COMPARATOR = (s1, s2) -> {
        LocalDateTime d1 = LocalDateTime.parse(s1, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        LocalDateTime d2 = LocalDateTime.parse(s2, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        return d2.compareTo(d1);
    };

    private static final Comparator<String> DATE_ASC_COMPARATOR = DATE_DESC_COMPARATOR.reversed();
    @Step("Проверяем сортировку списка по возрастанию")
    public static void assertListSortedByUserDesc(List<String> users) {
            List<String> usersCopy = new ArrayList<>(users);
            usersCopy.sort(USER_DESC_COMPARATOR);
            Assert.assertEquals(usersCopy, users);
    }
    @Step("Проверяем сортировку списка по убыванию")
    public static void assertListSortedByUserAsc(List<String> users) {
        List<String> usersCopy = new ArrayList<>(users);
        usersCopy.sort(USER_ASC_COMPARATOR);
        Assert.assertEquals(usersCopy, users);
    }


    private static final Comparator<String> USER_DESC_COMPARATOR = String::compareToIgnoreCase;
    private static final Comparator<String> USER_ASC_COMPARATOR = USER_DESC_COMPARATOR.reversed();

    @Step("Проверяем, что список элементов не отсортирован")
    public static void assertNotEqualsSorted(List<String> list) {
        List<String> listCopy = new ArrayList<>(list);
        listCopy.sort(USER_ASC_COMPARATOR);
        Assert.assertNotEquals(listCopy, list);
        listCopy.sort(USER_DESC_COMPARATOR);
        Assert.assertNotEquals(listCopy, list);

    }

}
