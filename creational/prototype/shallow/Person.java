package patterns.creational.prototype.shallow;

class Address {
    String city;
    Address(String city) {
        this.city = city;
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
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address.city + "}";
    }
    public static void main(String[] args) throws Exception{
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
        As seen in the output, modifying the address field in the cloned object also affects
        the original object because both the original and the clone share the same Address object.
         */
    }
}