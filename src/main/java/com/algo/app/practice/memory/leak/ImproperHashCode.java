package com.algo.app.practice.memory.leak;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImproperHashCode {
    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(new Person("bupp"), i+"");
        }

        System.out.println(map.size());
        System.out.println(map.get(new Person("bupp")));
    }
}
