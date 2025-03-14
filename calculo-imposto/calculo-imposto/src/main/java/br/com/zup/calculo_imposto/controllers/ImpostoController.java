package br.com.zup.calculo_imposto.controllers;


import br.com.zup.calculo_imposto.models.Imposto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class ImpostoController {

    @Autowired
    private ImpostoService impostoService;

    @GetMapping
    public ResponseEntity<List<Imposto>> ListarImposto() {
        return ResponseEntity.ok(impostoService.ListarImpostos());
    }
    @PostMapping
    public ResponseEntity<Imposto> cadastrarImposto(@RequestBody Imposto imposto) {
        return new ResponseEntity<>(impostoService.cadastrarImposto(imposto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imposto> obterImposto(@PathVariable Long id) {
        return ResponseEntity.ok(impostoService.obterImposto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirImposto(@PathVariable Long id) {
        impostoService.excluirImposto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/calculo")
    public ResponseEntity<Object> calcularImposto(@RequestParam Long tipoImpostoId, @RequestParam double valorBase) {
        Imposto imposto = impostoService.obterImposto(tipoImpostoId);
        double valorImposto = impostoService.calcularImposto(tipoImpostoId, valorBase);

        return ResponseEntity.ok(
                new CalculoResponse(imposto.getNome(), valorBase, imposto.getAliquota(), valorImposto));

    }

    public record CalculoResponse(String tipoImposto, double valorBase, double aliquota, double valorImposto) {

    }

}
