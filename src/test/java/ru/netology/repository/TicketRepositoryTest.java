package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1, 3599, "VKO", "SVX", 140);
    private Ticket second = new Ticket(2, 3673, "DME", "SVX", 145);
    private Ticket third = new Ticket(3, 4051, "SVO", "SVX", 155);
    private Ticket fourth = new Ticket(4, 4516, "DME", "SVX", 150);
    private Ticket fifth = new Ticket(5, 4586, "DME", "SVX", 150);

    @BeforeEach
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    public void ShouldFindAllTicket(){
        Ticket[] expected = new Ticket[]{first, second, third, fourth, fifth};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldSortById(){
        Ticket[] expected = new Ticket[]{first, second, third, fourth, fifth};
        Ticket[] actual = new Ticket[]{second, first, fifth, fourth, third};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

}