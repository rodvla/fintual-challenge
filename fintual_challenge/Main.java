package fintual_challenge;

import java.time.LocalDate;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<LocalDate, Float> mapStock1 = new HashMap<>();
        Map<LocalDate, Float> mapStock2 = new HashMap<>();
        Map<LocalDate, Float> mapStock3 = new HashMap<>();

        LocalDate date1 = LocalDate.parse("2021-01-01");
        LocalDate date2 = LocalDate.parse("2021-02-01");
        LocalDate date3 = LocalDate.parse("2021-03-01");
        LocalDate date4 = LocalDate.parse("2021-04-01");
        LocalDate date5 = LocalDate.parse("2021-05-01");
        LocalDate date6 = LocalDate.parse("2021-06-01");
        LocalDate date7 = LocalDate.parse("2021-07-01");
        LocalDate date8 = LocalDate.parse("2021-08-01");
        LocalDate date9 = LocalDate.parse("2021-09-01");
        LocalDate date10 = LocalDate.parse("2021-10-01");
        LocalDate date11 = LocalDate.parse("2021-11-01");
        LocalDate date12 = LocalDate.parse("2021-12-01");
        LocalDate date13 = LocalDate.parse("2022-01-01");

        mapStock1.put(date1, 10f );
        mapStock1.put(date2, 11f );
        mapStock1.put(date3, 12f );
        mapStock1.put(date4, 13f );
        mapStock1.put(date5, 14f );
        mapStock1.put(date6, 15f );
        mapStock1.put(date7, 16f );
        mapStock1.put(date8, 17f );
        mapStock1.put(date9, 18f );
        mapStock1.put(date10, 19f );
        mapStock1.put(date11, 20f );
        mapStock1.put(date12, 21f );
        mapStock1.put(date13, 22f );

        mapStock2.put(date1, 10f );
        mapStock2.put(date2, 20f );
        mapStock2.put(date3, 30f );
        mapStock2.put(date4, 40f );
        mapStock2.put(date5, 50f );
        mapStock2.put(date6, 60f );
        mapStock2.put(date7, 70f );
        mapStock2.put(date8, 80f );
        mapStock2.put(date9, 90f );
        mapStock2.put(date10, 100f );
        mapStock2.put(date11, 110f );
        mapStock2.put(date12, 120f );
        mapStock2.put(date13, 130f );

        mapStock3.put(date1, 21f );
        mapStock3.put(date2, 20f );
        mapStock3.put(date3, 19f );
        mapStock3.put(date4, 18f );
        mapStock3.put(date5, 17f );
        mapStock3.put(date6, 16f );
        mapStock3.put(date7, 15f );
        mapStock3.put(date8, 14f );
        mapStock3.put(date9, 13f );
        mapStock3.put(date10, 12f );
        mapStock3.put(date11, 11f );
        mapStock3.put(date12, 10f );
        mapStock3.put(date13, 9f );

        Stock stock1 = new Stock(mapStock1,"stock1");
        Stock stock2 = new Stock(mapStock2,"stock2");
        Stock stock3 = new Stock(mapStock3,"stock3");

        List<Stock> list = new ArrayList<>();
        list.add(stock1);
        list.add(stock2);
        list.add(stock3);

        Portfolio portfolio = new Portfolio(list);

        System.out.println(portfolio);
        System.out.println("=========================");
        System.out.println("------PROFIT ANUAL ------");
        System.out.println("=========================");
        portfolio.getProfit(date1,date13);
        System.out.println("=========================");
        System.out.println("--3 MESES RETORNO ANUAL--");
        System.out.println("=========================");
        portfolio.getAnnualizedReturn(date1,date4);
        System.out.println("=========================");
        System.out.println("--6 MESES RETORNO ANUAL--");
        System.out.println("=========================");
        portfolio.getAnnualizedReturn(date1,date7);
        System.out.println("=========================");
        System.out.println("--9 MESES RETORNO ANUAL--");
        System.out.println("=========================");
        portfolio.getAnnualizedReturn(date1,date10);
        System.out.println("=========================");
        System.out.println("-12 MESES RETORNO ANUAL--");
        System.out.println("=========================");
        portfolio.getAnnualizedReturn(date1,date13);

    }
}