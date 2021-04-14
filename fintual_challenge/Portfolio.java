package fintual_challenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Portfolio {

    private List<Stock> stocks = new ArrayList<>();

    public Portfolio(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Portfolio)) return false;
        Portfolio portfolio = (Portfolio) o;
        return getStocks().equals(portfolio.getStocks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStocks());
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "stocks=" + stocks +
                '}';
    }

    public void getProfit(LocalDate fechaDesde, LocalDate fechaHasta) {
       for (Stock s: stocks){
           System.out.println(s.getName() + " profit: " + s.getProfitStock(fechaDesde,fechaHasta));
       }
    }

    public void getAnnualizedReturn(LocalDate fechaDesde, LocalDate fechaHasta) {
        for (Stock s: stocks){
            System.out.println(s.getName() + " AnnualizedReturn: " + s.getAnnualizedReturnStock(fechaDesde,fechaHasta));
        }
    }


}
