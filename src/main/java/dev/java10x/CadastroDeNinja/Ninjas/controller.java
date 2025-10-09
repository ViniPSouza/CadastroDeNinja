package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
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
    public ResponseEntity<String> alteraNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        if (ninjaService.atualizarNinja(id, ninjaAtualizado) != null) {
            return ResponseEntity.ok("Dados do ninja com ID: " + id + " atualizado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não foi encontrado. ");
        }
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id: " + id + " não encontrado");
        }
    }


}
