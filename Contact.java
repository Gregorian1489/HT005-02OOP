public class Contact {
    public String name;
    public String phone;
    public String email;
    public String city;
    public String info;

    public Contact(String name, String phone, String city, String email, String info) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.email = email;
        this.info = info;
    }

    public void show() {
        System.out.printf("Имя контакта: %s \n", this.name);
        System.out.printf("Телефон: %s \n", this.phone);
        System.out.printf("email: %s \n", this.email);
        System.out.printf("Город: %s \n", this.city);
        System.out.printf("Информация о контакте: %s \n", this.info);
    }
}