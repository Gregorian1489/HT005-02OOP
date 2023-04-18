import java.util.Scanner;

public class ContactDelete {
    public static void delete_contact(Phonebook phonebook, Scanner in) {
        System.out.print("Введите имя удаляемой записи \n");
        String name = in.next();
        if (Phonebook.contact_exist(name)){
            phonebook.delete(name);
        }
        else {
            System.out.printf("Контакт с именем %s не найден.\n ", name);
        }

    }
}
