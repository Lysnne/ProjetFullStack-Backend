package ikasaidi.backend.controllers;


import ikasaidi.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/signin/{username}/{pwd}")
    public boolean signin(@PathVariable String username, @PathVariable String pwd){
        return customerService.login(username, pwd);
    }

    @GetMapping("/signin2")
    public boolean signin2(@RequestParam String username, @RequestParam String pwd){
        return customerService.login(username, pwd);
    }
}
