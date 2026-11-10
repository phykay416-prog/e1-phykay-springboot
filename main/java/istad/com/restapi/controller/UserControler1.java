package istad.com.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v2/users")
public class UserControler1 {

    @GetMapping
    public List<String> getAll(){
        return List.of(
                "phykay"
        );
    }

}
