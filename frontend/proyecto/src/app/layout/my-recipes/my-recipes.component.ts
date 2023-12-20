import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IRepositoryEmit, IRepositoryRes } from 'src/app/interfaces/repository.interface';
import { IFilterSearch } from 'src/app/interfaces/searchFilter.interface';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-my-recipes',
  templateUrl: './my-recipes.component.html',
  styleUrls: ['./my-recipes.component.scss']
})
export class MyRecipesComponent {
   myRecipes:IRepositoryRes[] = [];
   selectedRecipes:IRepositoryRes[]=[]
   filters:IFilterSearch={
    category:"",
    searchText:""
  };
  constructor(
    private route:Router,
    private recipeServ:RecipeService
  ){}

  ngOnInit(){
    this.recipeServ.getAllRecipesById().subscribe({
      next:(res)=>{
        this.myRecipes = res.filter(item=>item.usuario.id == 1)
      }
    })
  }

  createList(){
    const data = JSON.stringify(this.selectedRecipes)
    this.route.navigate(['selectingredients', data])
  }
  receiveFilters(filters:IFilterSearch){
    this.filters = filters;
    console.log(filters)
  }
  receiveRecipes(data:IRepositoryEmit){
    if(data.actions === "add"){
      this.selectedRecipes.push(data);
    }
    else{
      this.selectedRecipes = this.selectedRecipes.filter(item=>item.id !== data.id)
    }
  }

}
