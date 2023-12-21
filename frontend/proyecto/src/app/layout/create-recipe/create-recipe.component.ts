import { Component } from '@angular/core';
import {  FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IIngredientDTO, IIngredientRes } from 'src/app/interfaces/ingredient.interface';
import { IRecipeDTO } from 'src/app/interfaces/receta.interface';
import { RecipeService } from 'src/app/services/recipe.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-recipe',
  templateUrl: './create-recipe.component.html',
  styleUrls: ['./create-recipe.component.scss'],
})
export class CreateRecipeComponent {
  infoRecipeForm!:FormGroup;
  infoIngredientForm!:FormGroup;
  infoStepForm!:FormGroup;

  categories: string[] = [];
  ingredientes: IIngredientRes[] = [];
  listaProcedimientos :string[] = [];

  constructor(
    private fb: FormBuilder,
    private recipeServ: RecipeService
    ) {}

  ngOnInit() {
    // Inicializar los formularios
    this.infoRecipeForm = this.initInfoRecipeForm();
    this.infoIngredientForm = this.initIngredientForm();
    this.infoStepForm = this.fb.group({
      step:["",[Validators.required, Validators.minLength(5)]]
    })

    this.loadCategories();
  }

  // Metodo para agregar nuevo ingrediente
  crearIngrediente() {
    if(this.infoIngredientForm.valid){
      const newIngredient :IIngredientRes = this.infoIngredientForm.value;
      this.ingredientes.push(newIngredient);
      this.infoIngredientForm.reset();
    }
    else{
      Swal.fire({
        icon:"question",
        title:"Ingrediente inválido"
      })
    }
  }
  crearProcedimientos(){
    if(this.infoStepForm.valid){
      const { step } = this.infoStepForm.value
      this.listaProcedimientos.push(step);
      this.infoStepForm.reset()
    }
    else{
      Swal.fire({
        icon:"question",
        title:"Paso inválido"
      })
    }
  }
  borraIngrediente(id:number){
    this.ingredientes.splice(id,1)
  }
  borrarProcedimiento(id:number){
    this.listaProcedimientos.splice(id,1)
  }
  // Metodo para crear nueva receta
  crearReceta() {
    if(this.infoRecipeForm.valid &&
      this.ingredientes.length > 0 &&
      this.listaProcedimientos.length > 0){
      const categoria = this.valueHardcodeCategory(this.infoRecipeForm.value.categoria as string);
      const newRecipe :IRecipeDTO = {
        ...this.infoRecipeForm.value,
        categoria,
        procedimientos:this.listaProcedimientos.join(".")
      };
      console.log(newRecipe)

      this.recipeServ.createRecipe(newRecipe).subscribe({
        next:(recipeRes)=>{
          const ingredientFormat:IIngredientDTO[] = this.ingredientes.map(item=>({...item, recetaId:recipeRes.id}))
          ingredientFormat.forEach(ingrediente=>{
            this.recipeServ.createIngredients(ingrediente).subscribe({
              next:()=>console.log("registro de ingrediente exitoso")
            })
          })
        }
      })
    }
    else{
      Swal.fire({
        icon:"question",
        title:"Receta Inválida"
      })
    }
  }

  private loadCategories(): void {
    this.recipeServ.getAllCategories().subscribe({
      next: (categories) => {
        this.categories = categories.map((category) => category.nombre);
      },
    });
  }
  private initInfoRecipeForm(){
    return this.fb.group({
      categoria: ['8', [Validators.required]],
      visible: [false, [Validators.required]],
      nombre: ['', [Validators.required, Validators.minLength(5)]],
    })
  }
  private initIngredientForm(){
    return this.fb.group({
      nombre: ['',[Validators.required, Validators.minLength(2)]],
      cantidad: [0],
      tipo_medida: [''],
    })
  }

  private valueHardcodeCategory(category:string){
    switch (category) {
      case "postres": return 8;
      case "mariscos": return 11;
      case "guisos": return 10;
      case "pescados": return 9;
      default:
        return 0;
    }
  }
}
