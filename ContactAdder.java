import java.util.Scanner;

public class ContactAdder {
    public static Contact get_contact(Scanner in) {
        String name, phone, email, city, info;
        System.out.print("Введиите имя контакта \n");
        name = in.next();
        System.out.print("Введиите телефон контакта \n");
        phone = in.next();
        System.out.print("Введиите email контакта \n");
        email = in.next();
        System.out.print("Введиите город контакта \n");
        city = in.next();
        System.out.print("Введиите информацию о контакте \n");
        info = in.next();
        return new Contact(name, phone, city, email, info);
    }

}
//