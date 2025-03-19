package br.com.zup.calculo_imposto.repositorys;

import br.com.zup.calculo_imposto.models.Imposto;
import br.com.zup.calculo_imposto.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImpostoRepository extends JpaRepository<Imposto, Long> {
    Optional<Imposto> findByNome(String nome);
}
