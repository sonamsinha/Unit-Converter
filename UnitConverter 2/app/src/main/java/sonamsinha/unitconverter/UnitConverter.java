package sonamsinha.unitconverter;

/**
 * Created by sonamsinha on 2/10/16.
 */
public class UnitConverter {

    public static double celsius2Fahrenheit(double c){
        return 32+c*9/5;
    }
    public static double fahrenheit2Celsius(double f){
        return (f-32)*5/9;
    }
    public static double sqFeet2sqMeter(double sqft){
        return sqft/10.764;
    }
    public static double sqMeter2sqFeet(double sqmt){
        return sqmt*10.764;
    }
    public static double meters2Miles(double mt) {return mt/1609.344;}
    public static double meters2Yards(double mt) {return mt/0.9144;}
    public static double meters2Feet(double mt) {return mt/0.3048;}
    public static double miles2Meters(double mi) {return mi*1609.344;}
    public static double miles2Yards(double mi) {return mi*1760;}
    public static double miles2Feet(double mi) {return mi*5280;}
    public static double yards2Meters(double yd) {return yd*0.9144;}
    public static double yards2Miles(double yd) {return yd/1760;}
    public static double yards2Feet(double yd) {return yd*3;}
    public static double feet2Meters(double ft) {return ft*0.3048;}
    public static double feet2Miles(double ft) {return ft/5280;}
    public static double feet2Yards(double ft) {return ft/3;}

}
