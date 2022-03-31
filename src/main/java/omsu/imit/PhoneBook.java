package omsu.imit;

import java.util.*;

public class PhoneBook {


    private Map<Human, List<String>> book;

    //todo: Методы:
    // добавить телефон, +
    // удалить телефон, +
    // получить список телефонов по человеку, +
    // найти список людей по номеру телефона, +
    // найти всех людей с их телефонами по началу фамилии человека (результат – новое отображение
    //       такой же структуры, но содержащее только отобранные записи).


    public void setBook(Map<Human, List<String>> book) {
        if (book == null) {
            throw new IllegalArgumentException("map can't be null");
        }
        if (book.isEmpty()) {
            throw new IllegalArgumentException("map can't be empty");
        }
        this.book.clear();
        this.book.putAll(book);
    }

    private void setBook(Human h, List<String> phoneNums) {
        if (h != null && phoneNums != null && !phoneNums.isEmpty()) {
            book.put(h, phoneNums);
        } else throw new IllegalArgumentException("check args");
    }

    public Map<Human, List<String>> getBook() {
        return book;
    }


    //    конструктор по умолчанию
    public PhoneBook() {
//        Human h = new Human();
//        List<String> phoneNums = new ArrayList<>();
//        String phoneNum = "+79999999999";
//        phoneNums.add(phoneNum);
        book = new HashMap<>();
//        book.put(h, phoneNums);
    }

    //    конструктор с параметром Map
    public PhoneBook(Map<Human, List<String>> book1) {
        if (book1 == null && book1.isEmpty()) throw new IllegalArgumentException("check args");
        setBook(book1);
    }


    public void addPhoneNum(String phoneNum, Human h1) {
        if (phoneNum == null) throw new IllegalArgumentException("phoneNum can't be null");
        if (h1 == null) throw new IllegalArgumentException("Human can't be null");

//        if (!book.containsKey(h1)) throw new IllegalArgumentException("this map hasn't got this Human");
        if (!book.containsKey(h1)){
            List list = new ArrayList();
            list.add(phoneNum);
            book.put(h1, list);
        }
        else {

//        if (book.get(h1).contains(phoneNum)) {
//            throw new IllegalArgumentException("this Human has already got this phoneNum");
//        }

//        if (book.containsKey(h1)) {
            List<String> myList = book.get(h1);
            myList.add(phoneNum);
            book.put(h1, myList);
//        }
        }
    }


    public void deletePhoneNum(String phoneNum) {
        if (phoneNum == null) throw new IllegalArgumentException("phoneNum can't be null");
        if (phoneNum.isEmpty()) throw new IllegalArgumentException("phoneNum can't be empty");

        for (Human h : book.keySet()) {
            if (!book.get(h).contains(phoneNum)) {
                throw new IllegalArgumentException("no phoneNum to delete");
            }
            book.get(h).remove(phoneNum);

        }

    }

    public List<String> getPhoneNumByHuman(Human human) {
        if (human == null) throw new IllegalArgumentException("Human can't be null");
        if (!book.containsKey(human)) throw new IllegalArgumentException("this book hasn't got this human");

        return book.get(human);
    }

    public List<Human> getHumanByPhoneNum(String phoneNum) {
        if (phoneNum == null) throw new IllegalArgumentException("phoneNum can't be null");
        if (phoneNum.isEmpty()) throw new IllegalArgumentException("phoneNum can't be empty");

        boolean flag = false;
        List<Human> humanList = new ArrayList<>();
        for (Human h : book.keySet()) {
            if (book.get(h).contains(phoneNum)) {
                flag = true;
                if (!humanList.contains(h)) {
                    humanList.add(h);
                }
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("book doesn't contain this phoneNum");
        }
        return humanList;
    }

    public Map<Human, List<String>> getMapBySurnameStart( String prefix){

        if (prefix == null) throw new IllegalArgumentException("prefix can't be null");
        if (prefix.isEmpty()) throw new IllegalArgumentException("prefix can't be empty");

        Map<Human, List<String>> myPhoneBook= new HashMap<>();

        for (Human h : book.keySet()){
            if (h.getSurname().startsWith(prefix)){
                myPhoneBook.put(h, book.get(h));
            }
        }

        return myPhoneBook;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneBook)) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(book, phoneBook.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "book=" + book +
                '}';
    }
}
