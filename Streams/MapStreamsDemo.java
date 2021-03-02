package com.mph;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapStreamsDemo {
    public static void main(String[] args) {

        List<Person> people = createPeople();

        //collect it as a map with id
        System.out.println(people.stream()
                .collect(Collectors.toMap(person -> person.getId(), person -> person)));

        //collect it as map filtered based on age
        System.out.println(people.stream()
                .filter(person -> person.getAge() > 21)
                .collect(Collectors.toMap(person -> person.getId(), person -> person)));

        //groupby on age
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getAge)));

        //groupby on age with selective collect
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toList()))));

        //groupby on age and count of it
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getAge,Collectors.counting())));

    }

        public static List<Person> createPeople(){
                return Arrays.asList(new Person(1,23,"priya"),
                        new Person(2,22,"raji"),
                        new Person(3,20,"puja"),
                        new Person(4,21,"ajay"),
                        new Person(6,20,"vaish"),
                        new Person(5,21,"sudher"));
            }


}


class Person {
    int id, age;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
