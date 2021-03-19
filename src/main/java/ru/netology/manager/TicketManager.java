package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketManager() {

    }

    public void add(Ticket item){
        repository.save(item);
    }

    public Ticket[] findAllPriceSort(String from, String to){
        Ticket[] result = new Ticket[0];
        for (Ticket route : repository.findAll()){
            if(route.getFrom().equalsIgnoreCase(from) && route.getTo().equalsIgnoreCase(to)){
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length -1] = route;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAllTimeSort(String from, String to, Comparator<Ticket> comparator){
        Ticket[] result = new Ticket[0];
        for (Ticket route : repository.findAll()){
            if(route.getFrom().equalsIgnoreCase(from) && route.getTo().equalsIgnoreCase(to)){
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length -1] = route;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }


}
