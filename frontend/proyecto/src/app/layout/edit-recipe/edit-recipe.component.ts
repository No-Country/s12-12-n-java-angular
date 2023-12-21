import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-recipe',
  templateUrl: './edit-recipe.component.html',
  styleUrls: ['./edit-recipe.component.scss']
})
export class EditRecipeComponent {
  editRecetaForm!: FormGroup;
  categories: string[] = ["Guisos", "Postres", "Ensalada", "Jugos", "Fritura"];
  categoriaReceta: string = 'categoria';

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    // Inicializar los formularios
    //this.editRecetaForm = this.initEditRecetaForm();
    this.editRecetaForm = this.fb.group({
      categoriaReceta: ['categoria']
    });
  }
  // Metodo para agregar nuevo ingrediente
  editIngrediente() {
    console.log('crear ingrediente funcionando');
  }

  // Metodo para crear nueva receta
  editReceta() {
    console.log(this.editRecetaForm);
  }

    /**
   * crea un formulario para crear receta
   * @returns retorna un formGroup
   */
    initEditRecetaForm() {
      return this.fb.group({
        nombreReceta: ['', [Validators.required]],
        categoriaReceta: ['', [Validators.required]],
        urlImgReceta: ['', [Validators.required]],
        porcionesReceta: ['', [Validators.required]],
        tiempoCocinado: ['', [Validators.required]],
        nuevoIngrediente: ['', [Validators.required]],
        cantidadIngrediente: ['', [Validators.required]],
        preparacionReceta: ['', [Validators.required]],
      });
    }
}
