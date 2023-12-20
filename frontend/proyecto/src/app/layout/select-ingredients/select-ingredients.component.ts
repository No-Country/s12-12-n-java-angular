import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IIngredientCheck } from 'src/app/interfaces/ingredient.interface';
import { IRecipeList } from 'src/app/interfaces/receta.interface';
import { IRepositoryRes } from 'src/app/interfaces/repository.interface';

@Component({
  selector: 'app-select-ingredients',
  templateUrl: './select-ingredients.component.html',
  styleUrls: ['./select-ingredients.component.scss']
})
export class SelectIngredientsComponent {
  recipes :IRepositoryRes[] = [];
  formatRecipe:IRecipeList[]=[]
  selectedRecipe = 0
  currentRecipe!:IRecipeList;
  selectedIngredients:string[] = []
  constructor(
    private router:Router,
    private routeConfig:ActivatedRoute
    ){}

  toIngredients(){
    const data = JSON.stringify({
      ingredients:[... new Set(this.selectedIngredients)],
      recipes:[...this.formatRecipe.map(item=>item.name)]
    })

    this.router.navigate(['createlist', data])
  }

  ngOnInit(){
    this.recipes = JSON.parse(this.routeConfig.snapshot.params['data'])

    this.formatRecipe = this.recipes.map(item=>{
      const formatIngredients:IIngredientCheck[] = item.receta.ingredientes
        .map(ingredient=>({...ingredient, isCheck:true}))
      return {
        id:item.id,
        name:item.receta.nombre,
        ingredients:formatIngredients,
      }
    })

    this.selectedRecipe = this.recipes[0].id;
    this.currentRecipe = this.formatRecipe[0];

    this.selectedIngredients = this.formatRecipe.flatMap(recipe =>
      recipe.ingredients.map(ingredient => ingredient.nombre)
    );
  }

  changeCurrentRecipe(){
    const idSelected = Number(this.selectedRecipe);
    this.currentRecipe = this.formatRecipe.find(item => item.id === idSelected)!
  }

  receiveIngredients(ingredientData:IIngredientCheck){
    const idIngredient = this.findIngredientIdIntoCurrentRecipe(ingredientData.id);

    if(idIngredient !== -1){
      this.findAndReplaceIngredientCheckIntoRecipes(idIngredient,ingredientData)
      this.addOrFindAndDeleteIngredients(ingredientData);
    }
    else{
      console.log("no se encontro el elemento:", ingredientData)
    }
  }

  private findIngredientIdIntoCurrentRecipe(id:number){
    const idIngredient = this.currentRecipe.ingredients
      .findIndex(ingredient =>ingredient.id === id)
    return idIngredient;
  }

  private findAndReplaceIngredientCheckIntoRecipes(id:number, newIngredient:IIngredientCheck){
    this.formatRecipe.find(recipe=>recipe.id === Number(this.selectedRecipe))!
      .ingredients.splice(id, 1, newIngredient)
  }

  private addOrFindAndDeleteIngredients(ingredient:IIngredientCheck){
    if(ingredient.isCheck){
      this.selectedIngredients.push(ingredient.nombre);
    }
    else{
      const ingrediendtIndex = this.selectedIngredients.findIndex(item=>item === ingredient.nombre)
      this.selectedIngredients.splice(ingrediendtIndex,1);
    }
  }
}
