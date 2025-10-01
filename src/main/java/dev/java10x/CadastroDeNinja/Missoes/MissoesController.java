package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listaMissoes();
    }
    //POST -- MAndar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public  MissoesModel criarMissoes(@RequestBody MissoesModel missoes){
        return missoesService.criarMissoes(missoes);
    }
    //PUT -- Madar uma requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "Missao alterada com sucesso";
    }
    //DELETE -- Madar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorID(@PathVariable Long id){
        missoesService.deletarMissoesPorId(id);
    }


}
