public class Contact {

    private String name;
    private String number;
    public Contact(String name) {
        this.name = name;
        this.number = "default";
    }
    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact() {
        this.name = "default";
        this.number = "default";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
