package com.bank.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @GetMapping("/clients")
    public String showClients(){
        return "List of Clients";
    }
}
