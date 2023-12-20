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
ingredientes: any[] = [];
listaIngredientes: any[] = [];

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
      ingredientes: this.fb.array([
        this.fb.group({
          nombre: [''],
          cantidad: [0],
          tipo_medida: ['']
        })
      ]),
    //  nuevoIngrediente: [''],
    //  cantidadIngrediente: [''],
      procedimientos: [''],
    });


  }

  get ingredientesFormArray(): FormArray {
    return this.crearRecetaForm.get('ingredientes') as FormArray;
  }

  // Metodo para agregar nuevo ingrediente
  crearIngrediente() {
 // Accede a los controles del FormArray 'ingredientes'
 const ingredientesControls = this.ingredientesFormArray.controls;

 // Itera sobre cada control (que es un FormGroup) y obtén sus valores
 for (let i = 0; i < ingredientesControls.length; i++) {
  // const nuevoIngrediente = ingredientesControls[i].value;
   const nuevoIngrediente = ingredientesControls[ingredientesControls.length - 1].value;
   // Agrega el nuevo ingrediente a la lista de ingredientes
   this.listaIngredientes.push(nuevoIngrediente);
 }
    console.log('nuevoIngrediente');
  }

  // Metodo para crear nueva receta
  crearReceta() {
    Object.values(this.crearRecetaForm.controls).forEach(control => {
      control.markAsTouched();
    });
    console.log('Formulario:', this.crearRecetaForm);
    console.log('Valido:', this.crearRecetaForm.valid);
    console.log(this.ingredientes);
  //  this.crearRecetaForm.get('ingredientes').setValue(this.ingredientes);
    if (this.crearRecetaForm.valid) {
      const nuevaReceta = this.crearRecetaForm.value;
      nuevaReceta.ingredientes = this.listaIngredientes;
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
