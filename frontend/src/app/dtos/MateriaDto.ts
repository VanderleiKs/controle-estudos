export class MateriaDto {
  id: number | undefined;
  nome: string | undefined;
  horasEstudo: number | undefined;
  numeroQuestoesResolvidas: number | undefined; 
  numeroQuestoesAcertadas: number | undefined;
  numeroQuestoesErradas: number | undefined;

  constructor(){
    this.id = undefined;
    this.horasEstudo = 0;
    this.numeroQuestoesAcertadas = 0;
    this.numeroQuestoesErradas = 0;
    this.numeroQuestoesResolvidas = 0;
  }
}