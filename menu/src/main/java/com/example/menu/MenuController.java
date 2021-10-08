package com.example.menu;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://dashboard.whatabyte.app")
@RestController
public class MenuController {
    private final MenuRepository repository;

    MenuController(MenuRepository repository){
        this.repository = repository;
    }
    
    @GetMapping("/api/menu/items")
    List<Menu> all() {
        return repository.findAll();
    }

    @PostMapping("/api/menu/items")
    Menu newMenu(@RequestBody Menu newMenu){
        return repository.save(newMenu);
    }

    @GetMapping("/api/menu/items/{id}")
    Menu menu(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new MenuNotFoundException(id));
    }

    @PutMapping("/api/menu/items/{id}")
    Menu editMenu(@RequestBody Menu newMenu, @PathVariable Long id) {
        
        return repository.findById(id)
        .map(menu -> {
            menu.setName(newMenu.getName());
            menu.setPrice(newMenu.getPrice());
            menu.setImage(newMenu.getImage());
            menu.setDescription(newMenu.getDescription());
            return repository.save(menu);
        })
        .orElseGet(() -> {
            newMenu.setId(id);
            return repository.save(newMenu);
        });
    }

    @DeleteMapping("/api/menu/items/{id}")
    void deleteMenu(@PathVariable Long id) {
        repository.deleteById(id);
    } 

}
