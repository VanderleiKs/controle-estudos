import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, signal, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MateriaDto } from './dtos/MateriaDto';
import { FormsModule } from '@angular/forms';
import { CadastroMateriaComponent } from './components/cadastro-materia/cadastro-materia.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NgFor, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'Controle de estudos';
  newMateria = "";
  
  @ViewChild('materiaInput') materiaInput: ElementRef | undefined;
 

 constructor(private httpClient : HttpClient, private modalService: NgbModal) {
  }
  ngOnInit(): void {
    this.getMaterias();
  }

  
  materias = signal<MateriaDto[]>([]);

  baseUrl = "http://localhost:8080/api/materias"

  getMaterias() {
    this.httpClient.get<MateriaDto[]>(`${this.baseUrl}`).subscribe((data) => {
      this.materias.set(data);
  } );
  }

  removerMateria(idMateria: number | undefined){
    if(idMateria === undefined) return
    this.httpClient.delete(`${this.baseUrl}/${idMateria}/delete`).subscribe(() => {
      this.getMaterias();
    })
  }

  adicionarMateria(materiaNome: string){
    const materia = new MateriaDto();

    materia.nome = materiaNome;
    materia.numeroQuestoesAcertadas = 0;
    materia.numeroQuestoesErradas = 0;
    materia.numeroQuestoesResolvidas = 0;

    this.httpClient.post<MateriaDto>(`${this.baseUrl}/adicionar`, materia).subscribe((response) => {
      this.getMaterias();
    })
  }

  editarMateria(materia: MateriaDto){
    const modal = this.modalService.open(CadastroMateriaComponent);
    modal.componentInstance.materia = {...materia};
    modal.result.then((data) => {
      this.httpClient.post<MateriaDto>(`${this.baseUrl}/adicionar`, data).subscribe(() => {
        this.getMaterias();
      }
      );
  });
}
}
