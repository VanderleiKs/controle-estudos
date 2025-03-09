package com.vsystem.controle_estudos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Materia {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Integer id;
  private String nome;
  private Integer horasEstudo;
  private Integer numeroQuestoesResolvidas;
  private Integer numeroQuestoesAcertadas;
  private Integer numeroQuestoesErradas;


  // Getters and Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getHorasEstudo() {
    return horasEstudo;
  }

  public void setHorasEstudo(Integer horasEstudo) {
    this.horasEstudo = horasEstudo;
  }

  public Integer getNumeroQuestoesResolvidas() {
    return numeroQuestoesResolvidas;
  }

  public void setNumeroQuestoesResolvidas(Integer numeroQuestoesResolvidas) {
    this.numeroQuestoesResolvidas = numeroQuestoesResolvidas;
  }

  public Integer getNumeroQuestoesAcertadas() {
    return numeroQuestoesAcertadas;
  }

  public void setNumeroQuestoesAcertadas(Integer numeroQuestoesAcertadas) {
    this.numeroQuestoesAcertadas = numeroQuestoesAcertadas;
  }

  public Integer getNumeroQuestoesErradas() {
    return numeroQuestoesErradas;
  }

  public void setNumeroQuestoesErradas(Integer numeroQuestoesErradas) {
    this.numeroQuestoesErradas = numeroQuestoesErradas;
  }
}
