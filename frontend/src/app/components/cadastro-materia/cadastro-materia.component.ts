import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MateriaDto } from '../../dtos/MateriaDto';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-cadastro-materia',
  imports: [FormsModule],
  templateUrl: './cadastro-materia.component.html',
  styleUrl: './cadastro-materia.component.css'
})
export class CadastroMateriaComponent implements OnInit{
  @Input() materia: MateriaDto | undefined;
  @Output() materiaIdChange = new EventEmitter<MateriaDto>();

  editMateria: MateriaDto = new MateriaDto();
  ngOnInit(): void {

    this.editMateria = this.materia ? this.materia : new MateriaDto();
    
  }

  constructor(private activeModal: NgbActiveModal) { }


  salvarMateria() {
    this.activeModal.close(this.editMateria);
  }
}
