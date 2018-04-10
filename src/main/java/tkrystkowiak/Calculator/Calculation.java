package tkrystkowiak.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {
    public static double Calculate(char znak, double n1, double n2){
        double wynik = 0.0;

        if (znak=='+') {

            wynik = plus(n1, n2);
        }
        else if(znak=='-') {

            wynik = minus(n1, n2);
        }
        else if(znak=='/') {

            wynik = divide(n1, n2);
        }
        else if(znak=='*') {

            wynik = multiplicate(n1, n2);
        }
        else if(znak=='\u221A') {
            wynik = root(n1);
        }
        else if(znak=='!') {
            wynik = silnia(n1);
        }
        else{
            wynik = n1;
        }
        return wynik;
    }
    private static double plus(double a, double b){
        return  a + b;
    }
    private static double minus(double a, double b){
        return  a - b;
    }
    private static double divide(double a, double b){
        return  a / b;
    }
    private static double multiplicate(double a, double b){
        return  a * b;
    }
    private static double root(double a){
        return  Math.sqrt(a);
    }
    private static double silnia(double a){
        if(a==0)
            return 1;
        else
            return a*silnia(a-1);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
