package fintual_challenge;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Stock {

    private Map<LocalDate, Float> tablaPrecioFecha = new HashMap<>();
    private String name;

    public Stock() {
    }

    public Stock(Map<LocalDate, Float> tablaPrecioFecha, String name) {
        this.tablaPrecioFecha = tablaPrecioFecha;
        this.name = name;
    }

    public Map<LocalDate, Float> getTablaPrecioFecha() {
        return tablaPrecioFecha;
    }

    public void setTablaPrecioFecha(Map<LocalDate, Float> tablaPrecioFecha) {
        this.tablaPrecioFecha = tablaPrecioFecha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return getTablaPrecioFecha().equals(stock.getTablaPrecioFecha()) && getName().equals(stock.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTablaPrecioFecha(), getName());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "tablaPrecioFecha=" + tablaPrecioFecha +
                ", name='" + name + '\'' +
                '}';
    }

    public Float getPrice(LocalDate date) {
        return tablaPrecioFecha.get(date);
    }

    public Float getProfitStock(LocalDate fechaDesde, LocalDate fechaHasta) {
        Float valorInicial = this.getPrice(fechaDesde);
        Float valorFinal = this.getPrice(fechaHasta);
        return (valorFinal - valorInicial) / valorInicial;
    }

    public Float getAnnualizedReturnStock(LocalDate fechaDesde, LocalDate fechaHasta) {
        long dias = DAYS.between(fechaDesde, fechaHasta);
        Float periodo = 365f / dias;
        Float profit = this.getProfitStock(fechaDesde, fechaHasta);
        double pow = Math.pow(1 + profit, periodo);
        Double D = Double.valueOf(pow);
        float f = D.floatValue();
        return f -1 ;
    }
}
