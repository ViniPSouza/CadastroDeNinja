package dev.java10x.CadastroDeNinja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping
public class controller {

    @GetMapping("/boasvindas")
    public  String boasVindas(){
        return "Essa é minha primeira mensagem nesssa rota";
    }

}
