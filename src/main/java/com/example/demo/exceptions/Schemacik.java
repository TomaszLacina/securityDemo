package com.example.demo.exceptions;

import java.util.List;

public class Schemacik {


    private static class Event {
        String name;
        List<Event> dependentOn;

        public Event(String name, List<Event> dependentOn) {
            this.name = name;
            this.dependentOn = dependentOn;
        }
    }

    public static void main(String[] args) {

        Event event = new Event("Ostatni", List.of(
                new Event("przed ostatni", List.of(
                        new Event("przed przed ostatni1", List.of()),
                        new Event("przed przed ostatni2", List.of()),
                        new Event("inny przed ostatni2", List.of(
                                new Event("inny przed przed ostatni1", List.of()),
                                new Event("przed przed ostatni2", List.of(
                                        new Event("30", List.of(new Event("40", List.of(new Event("50", List.of())))))

                                )))),
                        new Event("jeszcze przed przed ostatni3", List.of()))
                )));


        System.out.println(event.name);

        printAllDescendands(event);


    }

    private static void printAllDescendands(Event event) {
        for (Event dependent : event.dependentOn) {
            System.out.println(dependent.name);
            printAllDescendands(dependent);
        }
    }


}

