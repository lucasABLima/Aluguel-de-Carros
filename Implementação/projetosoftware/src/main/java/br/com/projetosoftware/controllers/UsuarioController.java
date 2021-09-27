package br.com.projetosoftware.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosoftware.DTOs.UpdateAgenteDTO;
import br.com.projetosoftware.DTOs.UpdateContratanteDTO;
import br.com.projetosoftware.model.Agente;
import br.com.projetosoftware.model.Contratante;
import br.com.projetosoftware.repository.AgenteRepository;
import br.com.projetosoftware.repository.ContratanteRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private AgenteRepository agenteRepository;
    @Autowired
    private ContratanteRepository contratanteRepository;

   @PostMapping("/agente")
   public Agente cAgente(@RequestBody Agente agente) {
        return this.agenteRepository.save(agente);
   }
   @GetMapping("/agente/{id}")
   public Agente gAgente(@RequestParam("id") Long id) {
        return this.agenteRepository.getById(id);
   }
   @GetMapping("/agente")
   public List<Agente> lAgente() {
     return this.agenteRepository.findAll();
   }
   @PutMapping("/agente/{id}")
   public ResponseEntity<Agente> uAgente(@RequestBody UpdateAgenteDTO updateAgenteDTO, @RequestParam("id") Long id ) {
     Optional<Agente> agente = this.agenteRepository.findById(id);
     if(!agente.isPresent()) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
     Agente agenteInDb = agente.get();
     if(!updateAgenteDTO.getLogin().isEmpty()) {
          agenteInDb.setLogin(updateAgenteDTO.getLogin());
     }
     if(!updateAgenteDTO.getSenha().isEmpty()) {
          agenteInDb.setSenha(updateAgenteDTO.getSenha());
     }
     return new ResponseEntity<Agente>(this.agenteRepository.save(agenteInDb), HttpStatus.OK);
   }
   @DeleteMapping("/agente/{id}")
   public ResponseEntity<String> dAgente(@RequestParam("id") Long id) {
        try {
               this.agenteRepository.deleteById(id);
             return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
   }

   @PostMapping("/contratante")
   public Contratante cContratante(@RequestBody Contratante contratante) {
        return this.contratanteRepository.save(contratante);
   }
   @GetMapping("/contratante/{id}")
   public Contratante gContratante(@RequestParam("id") Long id) {
        return this.contratanteRepository.getById(id);
   }
   @GetMapping("/contratante") 
   public List<Contratante> lContratantes() {
        return this.contratanteRepository.findAll();
   }
   @PutMapping("/contratante/{id}")
   public ResponseEntity<Contratante> uContratante(@RequestBody UpdateContratanteDTO updateContratanteDTO, @RequestParam("id") Long id) {
        Optional<Contratante> cOptional = this.contratanteRepository.findById(id);

        if(!cOptional.isPresent()) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contratante contratante = cOptional.get();
        if(!updateContratanteDTO.getLogin().isEmpty()) {
          contratante.setLogin(updateContratanteDTO.getLogin());
        }
        if(!updateContratanteDTO.getSenha().isEmpty()) {
          contratante.setSenha(updateContratanteDTO.getSenha());
        }
        
        return new ResponseEntity<Contratante>(this.contratanteRepository.save(contratante), HttpStatus.OK);
   }
   @DeleteMapping("/contratante/{id}")
   public ResponseEntity<String> dContratante(@RequestParam("id") Long id) {
        try {
             this.contratanteRepository.deleteById(id);
             return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
   }
}
