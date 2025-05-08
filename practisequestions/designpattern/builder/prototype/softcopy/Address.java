package practisequestions.designpattern.builder.prototype.softcopy;

public class Address {
    String city;

    Address(String city){
        this.city = city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address){
        this.name = name;
        this.address = address;
    }

    public Person clone() throws CloneNotSupportedException {
       return (Person) super.clone();
    }
}