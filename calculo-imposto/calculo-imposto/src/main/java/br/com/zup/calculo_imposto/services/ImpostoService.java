package br.com.zup.calculo_imposto.services;

import br.com.zup.calculo_imposto.exceptions.ResourceNotFoundException;
import br.com.zup.calculo_imposto.models.Imposto;
import br.com.zup.calculo_imposto.repositorys.ImpostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpostoService {

    @Autowired
    private ImpostoRepository impostoRepository;

    public List<Imposto> listarImpostos() {
        return impostoRepository.findAll();
    }

    public Imposto cadastrarImposto(Imposto imposto) {
        return impostoRepository.save(imposto);
    }

    public Imposto obterImposto(Long id) {
        return impostoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Imposto não encontrado"));
    }

    public void excluirImposto(Long id) {
        impostoRepository.deleteById(id);
    }

    public double calcularImposto(Long tipoImpostoId, double valorBase) {

        Imposto imposto = obterImposto(tipoImpostoId);
        return valorBase * (imposto.getAliquota() / 100.0);
    }

    public List<Imposto> ListarImpostos() {
    return null;
    }
}
