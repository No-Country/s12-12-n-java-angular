import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IrecipeResponse } from 'src/app/interfaces/receta.interface';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-create-recipe',
  templateUrl: './create-recipe.component.html',
  styleUrls: ['./create-recipe.component.scss'],
})
export class CreateRecipeComponent {
  crearRecetaForm!: FormGroup;
  categories: string[] = ["Guisos", "Postres", "Ensalada", "Jugos", "Fritura"];
  categoria: string = 'categoria';


  constructor(private fb: FormBuilder, private recipeServ:RecipeService) { }

  ngOnInit() {
    // Inicializar los formularios

    this.crearRecetaForm = this.fb.group({
      categoria: ['8'],
      visible: [false],
      nombre: ['', [Validators.required]],
      urlImgReceta: [''],
      porcionesReceta: [''],
      tiempoCocinado: [''],
      nuevoIngrediente: [''],
      cantidadIngrediente: [''],
      procedimientos: [''],
    });


  }
  // Metodo para agregar nuevo ingrediente
  crearIngrediente() {
    console.log('crear ingrediente funcionando');
  }

  // Metodo para crear nueva receta
  crearReceta() {
    Object.values(this.crearRecetaForm.controls).forEach(control => {
      control.markAsTouched();
    });
    console.log('Formulario:', this.crearRecetaForm);
    console.log('Valido:', this.crearRecetaForm.valid);
    if (this.crearRecetaForm.valid) {
      const nuevaReceta = this.crearRecetaForm.value;

      this.recipeServ.crearNuevaReceta(nuevaReceta).subscribe(
        (response) => {
          console.log('Receta creada con éxito:', response);

        },
        (error) => {
          console.error('Error al crear la receta:', error);
        }
      );
    }
  }
}
