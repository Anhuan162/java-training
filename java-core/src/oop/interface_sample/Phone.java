package oop.interface_sample;

public abstract class Phone {
    private String name;

    public Phone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String phone;
    abstract void insertPhone(String name, String phone) throws Exception;

    abstract void removePhone(String name);

    abstract void updatePhone(String name, String newphone);

    abstract void searchPhone(String name);

    abstract void sort();
}
