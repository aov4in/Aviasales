package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from; //Аэропорт вылета
    private String to; //Аэропорт прилёта
    private int travelTime; //Время в пути


    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
