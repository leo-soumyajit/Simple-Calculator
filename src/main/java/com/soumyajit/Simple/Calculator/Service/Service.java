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
}
