import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs';
import { IrecipeResponse } from 'src/app/interfaces/receta.interface';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.scss']
})
export class RecipeDetailsComponent implements OnInit {

  public recipeDetails: IrecipeResponse = {
    id: 0,
    nombre: "",
    procedimientos: "",
    visible: true,
    likes: 0,
    categoria: {
      id: 0,
      nombre: ""
    },
    ingredientes: [
      {
        id: 0,
        nombre: "",
        cantidad: 0,
        tipo_medida: ""
      },
    ],
    procedimientosArray: []

  }

  private recipeService = inject(RecipeService);
  private activeRouter = inject(ActivatedRoute);
  private router = inject(Router);

  ngOnInit(): void {
    this.activeRouter.params
      .pipe(
        switchMap(({ id }) => this.recipeService.getRecipeById(id)),
      ).subscribe({
        next: (recipe) => {
          if (!recipe) return this.router.navigate(['/recipes'])
          this.recipeDetails = recipe
          this.extraerPasos(this.recipeDetails.procedimientos);
          return null;
        }
      })

    // if (!recipe) return this.router.navigate(['/recipes'])
    // console.log(recipe)
    // this.extraerPasos(this.recipeDetails.procedimientos);
    // this.recipeDetails = recipe


  }
  //CONVERTIR LOS PROCEDIMIENTOS EN UN ARRAY
  extraerPasos(procedimientos: string) {
    this.recipeDetails.procedimientosArray = procedimientos.split(".");
    console.log(this.recipeDetails.procedimientosArray);
  }
}