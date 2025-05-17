package patterns.creational.builder;


 class User {
    // Required parameters
    private final String firstName;
    private final String lastName;

    // Optional parameters
    private int age;
    private String phone;
    private final String address;

    // Private constructor only accessible through Builder
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.age=builder.age;;
        this.phone=builder.phone;;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;

        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String  phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age+ ", Phone: " + phone + ", Address: " + address;
    }
}

public class UserBuilderDemo {
    public static void main(String[] args) {
        User user = new User.UserBuilder("John", "Doe")
                .address("123 Main St")
                .age(40)
                .phone("123456789")
                .build();

        System.out.println(user);
    }
}
