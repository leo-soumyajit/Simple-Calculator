package com.soumyajit.Simple.Calculator.Service;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface{

    @Override
    public double add(double a, double b) {
        return a+b;
    }

    @Override
    public double substract(double a, double b) {
        return a-b;
    }

    @Override
    public double multiply(double a, double b) {
        return a*b;
    }

    @Override
    public double division(double a, double b) {
        if(b==0){
            throw new ArithmeticException("Cannot divide by Zero");
        }
        return a/b;
    }

    @Override
    public double sqrt(double a) {
        if(a<0){
            throw new ArithmeticException("Cant Cannot take the square root of a negative number");
        }
        return Math.sqrt(a);
    }

    @Override
    public double pow(double a, double b) {
        return Math.pow(a,b);
    }

    @Override
    public double log(double a) {
        if(a<=0){
            throw new ArithmeticException("Cannot take the logarithm of zero or a negative number");
        }
        return Math.log10(a);
    }

    @Override
    public double exponential(double a) {
        return Math.exp(a);
    }

    @Override
    public double sin(double a) {
        return Math.sin(Math.toRadians(a));
    }

    @Override
    public double cos(double a) {
        return Math.cos(Math.toRadians(a));
    }

    @Override
    public double tan(double a) {
        return Math.tan(Math.toRadians(a));
    }

    @Override
    public double cosec(double a) {
        double sinval = Math.sin(Math.toRadians(a));
        if(sinval == 0){
            throw new ArithmeticException("Cosecant is undefined for angles where sine is 0");
        }
        return (1/sinval);
    }

    @Override
    public double sec(double a) {
        double cosval = Math.cos(Math.toRadians(a));
        if(cosval == 0){
            throw new ArithmeticException("Secant is undefined for angles where cosine is 0");
        }
        return (1/cosval);
    }

    @Override
    public double cot(double a) {
        double tanval = Math.tan(Math.toRadians(a));
        if (tanval == 0) {
            throw new ArithmeticException("Cotangent is undefined for angles where tangent is 0 (e.g., 0°, 180°, 360°).");
        }
        return 1 / tanval;
    }
    @Override
    public double factorial(double a){
        if(a == 0 || a==1){
            return 1;
        }
        else{
            return a*factorial(a-1);
        }
    }
}
