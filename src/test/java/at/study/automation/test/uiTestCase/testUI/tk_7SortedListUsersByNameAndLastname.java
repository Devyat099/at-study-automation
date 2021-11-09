package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static at.study.automation.ui.browser.BrowserUtils.getElementsText;
import static at.study.automation.utils.CompareUtils.*;

public class tk_7SortedListUsersByNameAndLastname extends BaseUITest {

    private User admin;

    @BeforeMethod
    public void prepareFixtures() {

        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        User userOne = new User() {{
            setIsAdmin(false);
        }}.create();

        User userTwo = new User() {{
            setIsAdmin(false);
        }}.create();

        openBrowser("login");

    }

    @Test
    public void SortedListTest() throws InterruptedException {

        loginPage.login(admin);
        headerPage.administration.click();
        administrationPage.users.click();

        List<String> lastnameList = getElementsText(userTablePage.lastnameList);
        assertNotEqualsSorted(lastnameList);

        List<String> firstnameList = getElementsText(userTablePage.firstnameList);
        assertNotEqualsSorted(firstnameList);

        userTablePage.button("Фамилия").click();
        List<String> lastnameListSortedDesc = getElementsText(userTablePage.lastnameList);
        assertListSortedByUserDesc(lastnameListSortedDesc);

        List<String> firstnameListNoSorted = getElementsText(userTablePage.firstnameList);
        assertNotEqualsSorted(firstnameListNoSorted);


        userTablePage.button("Фамилия").click();
        List<String> lastnameListSortedAsc = getElementsText(userTablePage.lastnameList);
        assertListSortedByUserAsc(lastnameListSortedAsc);

        List<String> firstnameListNoSorted2 = getElementsText(userTablePage.firstnameList);
        assertNotEqualsSorted(firstnameListNoSorted2);

        userTablePage.button("Имя").click();
        List<String> firstnameListSortedDesc = getElementsText(userTablePage.firstnameList);
        assertListSortedByUserDesc(firstnameListSortedDesc);

        List<String> lastnameListNoSorted = getElementsText(userTablePage.lastnameList);
        assertNotEqualsSorted(lastnameListNoSorted);

        userTablePage.button("Имя").click();
        List<String> firstnameListSortedAsc = getElementsText(userTablePage.firstnameList);
        assertListSortedByUserAsc(firstnameListSortedAsc);

        List<String> lastnameListNoSorted2 = getElementsText(userTablePage.lastnameList);
        assertNotEqualsSorted(lastnameListNoSorted2);


    }
}