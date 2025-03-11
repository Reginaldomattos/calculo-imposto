package br.com.zup.calculo_imposto.repositorys;

import br.com.zup.calculo_imposto.models.Imposto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpostoRepository extends JpaRepository<Imposto, Long> {

}
