package com.joao.oleossystem.controller;

import org.apache.catalina.valves.CrawlerSessionManagerValve;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joao.oleossystem.model.Crianca;
import com.joao.oleossystem.service.CriancaService;

@RestController
@RequestMapping("/crianca")
public class CriancaController {

    CriancaService criancaService;

    public CriancaController(CriancaService criancaService){
        this.criancaService = criancaService;
    }

    @GetMapping
    public ResponseEntity<Crianca> buscarCrianca(@RequestParam Integer id){
        return ResponseEntity.ok(criancaService.buscarCriancaPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<Void> salvarCrianca(@RequestBody Crianca crianca){
        criancaService.salvarCrianca(crianca);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCrianca (@RequestParam Integer id, @RequestBody Crianca crianca){
        criancaService.atualizarCriancaPorId(id, crianca);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> excluirCrianca(@RequestParam Integer id){
        criancaService.deletarCriancaPorId(id);
        return ResponseEntity.ok().build();
    }

}
