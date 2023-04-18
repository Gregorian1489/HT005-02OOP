import java.io.*;
import java.util.ArrayList;

public class Phonebook {
    static ArrayList<Contact> phonebook = new ArrayList<Contact>();

    public Phonebook() {
        phonebook = new ArrayList<Contact>();
    }

    public Phonebook(ArrayList<Contact> contactsList) {
        phonebook = contactsList;
    }

    public void add(Contact contact){
        phonebook.add(contact);
    }

    public void show() {
        phonebook.forEach(Contact::show);
    }


    static Phonebook loadFile(int format, String path){
        switch (format) {
            case 1:
                return loadFileFormat1(path);
            case 2:
                return loadFileFormat2(path);
            default:
                return new Phonebook(new ArrayList<Contact>());
        }
    }

    static Phonebook loadFileFormat2(String path) {
        ArrayList<Contact> contactsList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String contact;
            while ((contact = br.readLine()) != null){
                String[] substring = contact.split(";");
                contactsList.add(new Contact(substring[0], substring[1], substring[2], substring[3], substring[4]));
            }

        } catch (IOException e) {
            e.printStackTrace();

            }
        return new Phonebook(contactsList);
    }

    static Phonebook loadFileFormat1(String path) {
        ArrayList<Contact> contactsList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String name, phone, city, email, info;

            while((name = br.readLine()) != null &&
                    (phone = br.readLine()) != null &&
                    (city = br.readLine()) != null &&
                    (email = br.readLine()) != null &&
                    (info = br.readLine()) != null) {
                contactsList.add(new Contact(name, phone, city, email, info));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Phonebook(contactsList);
    }

    void writeToFile(int format, String path) {
        switch (format) {
            case 1:
                writeToFileFormat1(path);
            case 2:
                writeToFileFormat2(path);
            default:
                break;
        }
    }

    void writeToFileFormat1(String path) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), "utf-8"))) {
            for(Contact c : phonebook) {
                writer.write(c.name + "\n");
                writer.write(c.phone + "\n");
                writer.write(c.city + "\n");
                writer.write(c.email + "\n") ;
                writer.write(c.info + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeToFileFormat2(String path) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), "utf-8"))) {
            for(Contact c : phonebook) {
                writer.write(c.name + ";");
                writer.write(c.phone + ";");
                writer.write(c.city + ";");
                writer.write(c.email + ";") ;
                writer.write(c.info + ";\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean contact_exist(String name) {
        for (Contact c: phonebook) {
            if (c.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void delete(String name) {
        phonebook.removeIf(c -> c.name.equals(name));
    }
}

