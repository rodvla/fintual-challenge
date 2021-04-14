# Fintual Challenge
Construct a simple Portfolio class that has a collection of Stocks and a "Profit" method that receives 2 dates and returns the profit of the Portfolio between those dates. Assume each Stock has a "Price" method that receives a date and returns its price.
Bonus Track: make the Profit method return the "annualized return" of the portfolio between the given dates.

##### Stack of technologies: 
- Java 

# How to start the project:

Open the project in IntelliJ and run the main Class.

# Class Portfolio (resume):
~~~
public class Portfolio {

    private List<Stock> stocks = new ArrayList<>();

    public Portfolio(List<Stock> stocks) {
        this.stocks = stocks;
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
~~~

# Class Stock(resume):
~~~
public class Stock {

    private Map<LocalDate, Float> tablaPrecioFecha = new HashMap<>();
    private String name;

    public Stock(Map<LocalDate, Float> tablaPrecioFecha, String name) {
        this.tablaPrecioFecha = tablaPrecioFecha;
        this.name = name;
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
~~~

# Output

~~~
=========================
------PROFIT ANUAL ------
=========================
stock1 profit: 1.2
stock2 profit: 12.0
stock3 profit: -0.5714286
=========================
--3 MESES RETORNO ANUAL--
=========================
stock1 AnnualizedReturn: 1.8980341
stock2 AnnualizedReturn: 275.4952
stock3 AnnualizedReturn: -0.46482772
=========================
--6 MESES RETORNO ANUAL--
=========================
stock1 AnnualizedReturn: 1.5800207
stock2 AnnualizedReturn: 49.606144
stock3 AnnualizedReturn: -0.49263334
=========================
--9 MESES RETORNO ANUAL--
=========================
stock1 AnnualizedReturn: 1.3588076
stock2 AnnualizedReturn: 20.726828
stock3 AnnualizedReturn: -0.5267845
=========================
-12 MESES RETORNO ANUAL--
=========================
stock1 AnnualizedReturn: 1.2
stock2 AnnualizedReturn: 12.0
stock3 AnnualizedReturn: -0.5714286
~~~