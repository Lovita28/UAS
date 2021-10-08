package com.example.menu;

class MenuNotFoundException extends RuntimeException{

    MenuNotFoundException(Long id){
        super("Menu tidak tersedia " + id);
    }
    
}
