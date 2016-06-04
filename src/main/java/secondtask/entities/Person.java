package secondtask.entities;

/**
 * Created by alexandermiheev on 04.06.16.
 */



public class Person implements Comparable {
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person() {
        this.name = "";
        this.age = 0;
        this.sex = Sex.MALE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person tempPerson = (Person) o;
        return this.age - tempPerson.age;
    }
    @Override
    public String toString() {
        return getName() + " " + getSex().toString() + " " + getAge();
    }
}
