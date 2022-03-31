package omsu.imit;

import org.junit.Test;
import java.util.*;

import java.util.Collections;
import static org.junit.Assert.assertEquals;
import static omsu.imit.PhoneBook.*;

public class PhoneBookTest {
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullPhoneNum(){
        Human h1 = new Human();
        PhoneBook book = new PhoneBook();
        book.addPhoneNum(null,h1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddPhoneNumNullHuman(){
        PhoneBook book = new PhoneBook();
        String phoneNum = "+79624567878";
        book.addPhoneNum(phoneNum,null);
    }
    @Test
    public void testAddPhoneNumNoHumanKey(){
        PhoneBook myBook = new PhoneBook();
        Human h1 = new Human();
        String phoneNum = "+79624567878";
        myBook.addPhoneNum(phoneNum, h1);
        Map book = new HashMap<Human, List<String>>();
        List phoneNumList = new ArrayList();
        phoneNumList.add(phoneNum);
        book.put(h1, phoneNumList);
        PhoneBook book1 = new PhoneBook();
        book1.setBook(book);

//        ???
        assertEquals(book1, myBook);

    }


}

