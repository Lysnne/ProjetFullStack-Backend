package ikasaidi.backend.controllers;

import ikasaidi.backend.entity.TblAction;
import ikasaidi.backend.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/action")
@CrossOrigin()
public class ActionController {

    @Autowired
    ActionRepository actionRepository;

    @GetMapping
    public List<TblAction> getAll(){
        return actionRepository.findAll();
    }


}
