package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos  os meu ninjas
    public List<NinjaModel> listarNinja(){
        return ninjaRepository.findAll();
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar ninja - tem que ser um metodo VOID
    public void  deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);
    }
    //atualizar ninja
    public NinjaModel atualizarNinaja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return  ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }




}
