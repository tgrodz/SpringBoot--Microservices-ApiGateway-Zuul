package com.cashbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashboxController {

    @GetMapping("/cashbox")
    public String showCashboxs(){
        return "Cashbox Service";
    }
}
