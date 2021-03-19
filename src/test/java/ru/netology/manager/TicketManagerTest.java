package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceComparator;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
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
    public void ShouldNotFound(){
        String airportFrom = "SVO";
        String airportTo = "DME";

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotFoundTicket(){
        String airportFrom = "SVX";
        String airportTo = "DME";

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldFoundAllTicket(){
        String airportFrom = "DME";
        String airportTo = "SVX";

        Ticket[] expected = new Ticket[]{second, fourth, fifth};
        Ticket[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }
//---
    @Test
    public void ShouldFoundAllPriceSort(){
        String airportFrom = "DME";
        String airportTo = "SVX";

        Ticket[] expected = new Ticket[]{second, fourth, fifth};
        Ticket[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFoundAllTimeSort(){
        String airportFrom = "DME";
        String airportTo = "SVX";
        Comparator<Ticket> comparator = new TicketByPriceComparator();

        Ticket[] expected = new Ticket[]{second, fourth, fifth};
        Ticket[] actual = manager.findAllTimeSort(airportFrom, airportTo, comparator);
        assertArrayEquals(expected, actual);
    }

}