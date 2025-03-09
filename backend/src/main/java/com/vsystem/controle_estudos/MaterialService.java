package com.vsystem.controle_estudos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
  
  @Autowired
  private MaterialRepository materialRepository;

  public Materia saveMaterial(Materia material) {
    return materialRepository.save(material);
  }

  public Materia getMaterialById(int id) {
    return materialRepository.findById(id).orElse(null);
  }

  public void deleteMaterial(int id) {
    materialRepository.deleteById(id);
  }

  public List<Materia> getMaterials() {
    return materialRepository.findAll();
  }

 /*  public Material updateMaterial(Material material) {
    Material existingMaterial = materialRepository.findById(material.getId()).orElse(null);
    existingMaterial.setTitulo(material.getTitulo());
    existingMaterial.setDescricao(material.getDescricao());
    existingMaterial.setLink(material.getLink());
    return materialRepository.save(existingMaterial);
  } */
}
