package com.soumyajit.Simple.Calculator.Controller;


import com.soumyajit.Simple.Calculator.Advices.CalculatorResponse;
import com.soumyajit.Simple.Calculator.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class Controller {
    private final Service service;


    public Controller(Service service) {
        this.service = service;
    }


    @GetMapping("/add")
    public ResponseEntity<CalculatorResponse<Double>> add(@RequestParam double a , @RequestParam double b){
        try{
            double res =  service.add(a,b);
            CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Addition Done ",HttpStatus.OK);
            return new ResponseEntity<>(response , HttpStatus.OK);
        } catch (ArithmeticException e) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Arithmetic error occurred",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/subs")
    public ResponseEntity<CalculatorResponse<Double>> subs(@RequestParam double a , @RequestParam double b){
        try{
            double res =  service.substract(a,b);
            CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Subtraction Done",HttpStatus.OK);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (ArithmeticException e) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Arithmetic error occurred",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/multiply")
    public ResponseEntity<CalculatorResponse<Double>> multiply(@RequestParam double a , @RequestParam double b){
        try{
            double res =  service.multiply(a,b);
            CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Multiply Done",HttpStatus.OK);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (ArithmeticException e) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Arithmetic error occurred",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/division")
    public ResponseEntity<CalculatorResponse<Double>> division(@RequestParam double a , @RequestParam double b){
        if(b==0){
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Cannot divide by Zero",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        double res =  service.division(a,b);
        CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Division Done",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/sqrt")
    public ResponseEntity<CalculatorResponse<Double>> sqrt(@RequestParam double a){
        if(a<0){
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Cant Cannot take the square root of a negative number",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        double res =  service.sqrt(a);
        CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Square root calculation done",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/pow")
    public ResponseEntity<CalculatorResponse<Double>> pow(@RequestParam double a,@RequestParam double b){
        double res =  service.pow(a,b);

        if(Double.isInfinite(res)){
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Result is too large to represent (overflow)",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Pow Done",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @GetMapping("/log")
    public ResponseEntity<CalculatorResponse<Double>> log(@RequestParam double a){
        if(a<=0){
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Cannot take the logarithm of zero or a negative number" , HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        }
        double res = service.log(a);
        CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Logarithm Calculation is Done",HttpStatus.OK);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @GetMapping("/exponential")
    public ResponseEntity<CalculatorResponse<Double>> exponential(@RequestParam double a){

        double res = service.exponential(a);
        if(Double.isNaN(res)) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null,"Invalid input: result is undefined",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        CalculatorResponse<Double> response = new CalculatorResponse<>(res, "Exponential Calculation Done", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/sin")
    public ResponseEntity<CalculatorResponse<Double>> sin(@RequestParam double a){
        try{
            double res =  service.sin(a);
            CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Sine Calculation Done",HttpStatus.OK);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (ArithmeticException e) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Error occurred",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/cos")
    public ResponseEntity<CalculatorResponse<Double>> cos(@RequestParam double a){
        try{
            double res =  service.cos(a);
            CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Cos Calculation Done",HttpStatus.OK);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (ArithmeticException e) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Error occurred",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/tan")
    public ResponseEntity<CalculatorResponse<Double>> tan(@RequestParam double a){
        if(a==90){
            CalculatorResponse<Double> response = new CalculatorResponse<>(null,"Tan 90 is undefined",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        try{
            double res =  service.tan(a);
            CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Tan Calculation Done",HttpStatus.OK);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (ArithmeticException e) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null , "Error occurred",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/cosec")
    public ResponseEntity<CalculatorResponse<Double>> cosec(@RequestParam double a){
        double res =  service.cosec(a);
        if(a == 0) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null, "Cosecant is undefined for angles 0", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Cosecant Calculation Done",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/sec")
    public ResponseEntity<CalculatorResponse<Double>> sec(@RequestParam double a){
        double res =  service.sec(a);
        if(a == 90) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null, "Secant is undefined for angles 90", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Secant Calculation Done",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/cot")
    public ResponseEntity<CalculatorResponse<Double>> cot(@RequestParam double a){
        if(a == 90){
            CalculatorResponse<Double> response = new CalculatorResponse<>(0.0,"Cotangent Calculation Done",HttpStatus.OK);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        double res =  service.cot(a);
        if(a == 0 || a==180 || a==360) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null, "Cotangent is undefined for angles  (e.g., 0°, 180°, 360°).", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        CalculatorResponse<Double> response = new CalculatorResponse<>(res,"Cotangent Calculation Done",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/factorial")
    public ResponseEntity<CalculatorResponse<Double>> factorial (@RequestParam double a){
        double res = service.factorial(a);
        if(a<0){
            CalculatorResponse<Double> response = new CalculatorResponse<>(null, "Cannot take the Factorial of negetive Value",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        CalculatorResponse<Double> response = new CalculatorResponse<>(res ,"Factorial Calculations Done",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
    @GetMapping("/gcd")
    public ResponseEntity<CalculatorResponse<Double>> gcd(@RequestParam double a, @RequestParam double b) {
        // Round the input values to nearest integer
        int s = (int) Math.round(a);
        int r = (int) Math.round(b);

        if (s == 0 && r == 0) {
            CalculatorResponse<Double> response = new CalculatorResponse<>(null, "GCD is undefined for both numbers being zero", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        s = Math.abs(s);
        r = Math.abs(r);

        double res = service.gcd(s, r);

        CalculatorResponse<Double> response = new CalculatorResponse<>(res, "GCD Calculation Done", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
