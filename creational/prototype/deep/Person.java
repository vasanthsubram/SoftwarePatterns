package patterns.creational.prototype.deep;

class Address implements Cloneable {
    String city;

    Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    String name;
    int age;
    Address address;

    Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static void main(String[] args) throws Exception {
        Address address = new Address("New York");
        Person original = new Person("Alice", 30, address);
        Person cloned = (Person) original.clone();
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        // Modify the address in the cloned object
        cloned.address.city = "Los Angeles";

        System.out.println("After modifying cloned object:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        /*
          In this case, modifying the address field in the cloned object does not affect the original object
          because both the original and the clone have their own separate Address objects.
        */
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone(); // Deep copy of address
        return cloned;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address.city + "}";
    }
}