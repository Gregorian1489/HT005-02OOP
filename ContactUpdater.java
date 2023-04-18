import java.util.Scanner;

public class ContactUpdater {
    public static void update_contact(Phonebook phonebook, Scanner in) {
        System.out.print("Введите имя изменяемой записи \n");
        String name = in.next();
        if (Phonebook.contact_exist(name)){
            System.out.printf("Изменение контакта '%s' \n", name);
            Contact contact = ContactAdder.get_contact(in);
            phonebook.delete(name);
            phonebook.add(contact);
        }
        else {
            System.out.printf("Контакт с именем %s не найден.\n ", name);
        }

    }
}
