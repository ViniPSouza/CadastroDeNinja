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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinja() {
        return ninjaService.listarNinja();
    }

    //Mostrar  Ninjas por  id (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listaNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    //Altera dados dos ninjas (UPDATE)
    @PutMapping("/altera/{id}")
    public NinjaDTO alteraNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }


}
