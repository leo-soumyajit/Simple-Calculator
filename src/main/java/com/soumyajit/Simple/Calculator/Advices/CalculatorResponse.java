package com.soumyajit.Simple.Calculator.Advices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorResponse <T>{
    private T res;
    private String msg;
    private HttpStatus status;

    public CalculatorResponse(HttpStatus status) {
        this.status = status;
    }
}
