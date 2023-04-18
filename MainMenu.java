import java.util.Scanner;

public class MainMenu {

    public static void menu() {
        System.out.println("==МЕНЮ==");
        System.out.println("[1] Отобразить список контактов");
        System.out.println("[2] Добавить контакт");
        System.out.println("[3] Редактировать контакт");
        System.out.println("[4] Удалить контакт");
        System.out.println("[5] Сохранить контакт");
        System.out.println("[6] Загрузить из файла");
        System.out.println("[7] Выход");
    }

    public static void show(Phonebook phonebook) {
        boolean exit = false;

        while (!exit) {
            menu();
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    phonebook.show();
                    break;
                case 2:
                    phonebook.add(ContactAdder.get_contact(scan));
                    break;
                case 3:
                    ContactUpdater.update_contact(phonebook, scan);
                    break;
                case 4:
                    ContactDelete.delete_contact(phonebook, scan);
                    break;
                case 5:
                    System.out.print("Выберите формат [1, 2] \n");
                    phonebook.writeToFile(scan.nextInt(), "phonebook.txt");
                    break;
                case 6:
                    System.out.print("Выберите формат [1, 2] \n");
                    Phonebook.loadFile(scan.nextInt(),"phonebook.txt");
                    break;
                case 7:
                    System.out.println("exit");
                    scan.close();
                    exit = true;
                    break;
                default:
                    System.out.println("INVALID");
                    break;
            }
        }
    }
}

