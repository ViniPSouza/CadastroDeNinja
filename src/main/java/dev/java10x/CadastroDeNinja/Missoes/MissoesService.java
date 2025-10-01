package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missoes
    public List<MissoesModel> listaMissoes(){
        return missoesRepository.findAll();
    }
    //Criar novas missoes
    public MissoesModel criarMissoes(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }
    //Deletar missoes por ID
    public  void deletarMissoesPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
