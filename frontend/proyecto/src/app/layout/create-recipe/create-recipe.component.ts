import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-recipe',
  templateUrl: './create-recipe.component.html',
  styleUrls: ['./create-recipe.component.scss'],
})
export class CreateRecipeComponent {
  crearRecetaForm!: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    // Inicializar los formularios
    this.crearRecetaForm = this.initCrearRecetaForm();
  }
  // Metodo para agregar nuevo ingrediente
  crearIngrediente() {
    console.log('crear ingrediente funcionando');
  }

  // Metodo para crear nueva receta
  crearReceta() {
    console.log(this.crearRecetaForm);
  }

  /**
 * crea un formulario para crear receta
 * @returns retorna un formGroup
 */
  initCrearRecetaForm() {
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
