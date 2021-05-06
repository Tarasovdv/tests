package ru.itsjava;

import com.sun.source.tree.NewArrayTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itsjava.hw.Person;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс Person должен: ")
public class PersonTest {

    public static final String DEFAULT_NAME = "Dima";
    public static final int DEFAULT_AGE = 29;
    public static final int AFTER_BIRTHDAY_AGE = 30;

    @DisplayName(" корректно заполнять конструктор")
    @Test
    public void shouldHaveCorrectConstructor() {
        Person person = new Person(DEFAULT_NAME, DEFAULT_AGE);

//        assertEquals(DEFAULT_NAME, person.getName());
//        assertEquals(DEFAULT_AGE, person.getAge());

        assertAll("person",
                ()-> assertEquals(DEFAULT_NAME,person.getName()),
                ()-> assertEquals(DEFAULT_AGE,person.getAge()));
    }

    @DisplayName(" прибавлять +1 к возрасту")
    @Test
    public void shouldHavePlusOneYear(){
        Person person = new Person(DEFAULT_NAME, DEFAULT_AGE);

        person.birthday();
        assertEquals(AFTER_BIRTHDAY_AGE,person.getAge());
    }

    @DisplayName(" должен показать корректный статус на покупку алкоголя")
    @Test
    public void shouldHaveReturnPermission(){
        Person person = new Person(DEFAULT_NAME, DEFAULT_AGE);
        Person person1 = new Person(DEFAULT_NAME, 17);

        assertTrue(person.takeBear());
        assertFalse(person1.takeBear());
        person1.birthday();
        assertTrue(person1.takeBear());
    }
}
