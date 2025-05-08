package practisequestions.designpattern.builder.prototype.deepcopy;

public class Address {
    String city;

    Address(String city) {
        this.city = city;
    }

    public Address clone() {
        return new Address(this.city); //Deep copy of nested object....
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person clone() {
        return new Person(this.name, this.address.clone()); //this gives the deep copy ...
    }
}

/*

Summary : Deep copy is creating the object  with new keyword which creates the container but the data it holds are cloned  or reused not created  every time..

🔸 Advantage:
Now changing the cloned address.city won’t affect the original, because it's fully independent.
*
* */
