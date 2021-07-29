package test.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayCovarianceTest {
    class Person{};
    class Employee extends Person{};
    class Student extends Person{};

    @Test
    public void doTest(){
        Person[] p;
        p = new Employee[3];
        Throwable exception = assertThrows(ArrayStoreException.class , () -> {
            p[0] = new Student();
        });
    }
}
