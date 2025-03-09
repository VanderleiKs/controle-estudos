package com.vsystem.controle_estudos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/materias")
public class RestController {

  @Autowired
  private MaterialService materialService;


  @GetMapping("")
  public List<Materia> getMateriais() {
    return materialService.getMaterials();
  }

  @DeleteMapping("/{id}/delete")
  public ResponseEntity<?> delete(@PathVariable Integer id){
    materialService.deleteMaterial(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/adicionar")
  public ResponseEntity<?> adicionar(@RequestBody Materia  materia){
    return ResponseEntity.ok(materialService.saveMaterial(materia));
  }
}
