package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class controller {

    private NinjaService ninjaService;

    public controller(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public  String boasVindas(){
        return "Essa é minha primeira mensagem nesssa rota";
    }


    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinja() {
        return ninjaService.listarNinja();
    }

    //Mostrar  Ninjas por  id (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjaPorId(){
        return "Mostra Ninja por id ";
    }

    //Altera dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Ninja deletado por id";
    }


}
