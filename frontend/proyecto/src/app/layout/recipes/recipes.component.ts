import { Component } from '@angular/core';
import { IrecipeResponse } from 'src/app/interfaces/receta.interface';
import { IFilterSearch } from 'src/app/interfaces/searchFilter.interface';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.scss']
})
export class RecipesComponent {
  recipes:IrecipeResponse[] = [];
  recipeMostLike:IrecipeResponse[] = [];
  randomRecipes:IrecipeResponse[] = [];
  filters:IFilterSearch={
    category:"",
    searchText:""
  };
  constructor(
    private recipeServ:RecipeService
  ){}

  ngOnInit(){
    this.recipeServ.getAllRecipes().subscribe({
      next:(res)=>{
        this.recipes = res;
        this.recipeMostLike = [...this.recipes]
          .sort((a,b)=> b.likes -a.likes)
          .slice(0,5)
        this.randomRecipes = this.randomPicker(this.recipes)
          .slice(0,5)
      }
    })
  }

  private randomPicker(data : IrecipeResponse[]){
    return [...data].sort(()=>(Math.random() - 0.5))
  }

  receiveFilters(filters:IFilterSearch){
    this.filters = filters;
    console.log(filters)
  }
}
