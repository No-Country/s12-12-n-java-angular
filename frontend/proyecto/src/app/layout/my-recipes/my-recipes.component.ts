import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { scaling } from 'src/app/animations/animation';
import { IRepositoryEmit, IRepositoryRes } from 'src/app/interfaces/repository.interface';
import { IFilterSearch } from 'src/app/interfaces/searchFilter.interface';
import { RecipeService } from 'src/app/services/recipe.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-my-recipes',
  templateUrl: './my-recipes.component.html',
  styleUrls: ['./my-recipes.component.scss'],
  animations:[scaling]
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
    if(this.selectedRecipes.length !== 0){
      const data = JSON.stringify(this.selectedRecipes)
      this.route.navigate(['selectingredients', data])
    }
    else{
      Swal.fire({
        title:"Error",
        text:"Debe seleccionar al menos una receta",
        icon:'warning'
      })
    }
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
