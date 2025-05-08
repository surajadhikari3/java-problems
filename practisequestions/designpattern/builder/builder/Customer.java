package practisequestions.designpattern.builder.builder;

/**
 * here the field setter is done by the builder class which is the inner static class. In the constructor we pass the builder which is responsible for setting all the value.
 * in builder class every setter method return the builder object and in the build method the instance of outer main class is called with the builder object.
 */

public class Customer {

    private long id;
    private String name;
    private int age;
    private String address;

    public Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private long id;
        private String name;
        private int age;
        private String address;

        //Builder method to set the properties......

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

    }

    public static void main(String[] args) {

        Customer customer = new Builder().setId(1).setName("Suraj").setAddress("Toronto").build();

        System.out.println(customer);
    }

}
