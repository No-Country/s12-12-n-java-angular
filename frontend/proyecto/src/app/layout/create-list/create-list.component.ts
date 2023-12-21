import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IListDTO, IListDataRoute, IListIngredient } from 'src/app/interfaces/list.interface';

@Component({
  selector: 'app-create-list',
  templateUrl: './create-list.component.html',
  styleUrls: ['./create-list.component.scss']
})
export class CreateListComponent {
  ingredients: string[] = [];
  recipes: string[] = [];
  ingredientField = "";

  constructor(
    private routeConfig:ActivatedRoute,
    private route:Router
  ){}

  ngOnInit(){
    const dataRoute = this.routeConfig.snapshot.params['data']
    const data :IListDataRoute = JSON.parse(dataRoute);
    this.ingredients = data.ingredients;
    this.recipes = data.recipes
  }

  saveList(){
    const data:IListDTO = {
      createdAt : new Date(),
      ingredients: this.ingredients,
      recipes:this.recipes
    }
    this.route.navigate(['mylist'])
  }

  receiveIngredient(ingredientStatus:IListIngredient){
    console.log(ingredientStatus)
    if(ingredientStatus.status === "delete"){
      this.findAndDelete(ingredientStatus);
    }
    else{
      this.findAndUpdate(ingredientStatus);
    }
  }
  private findAndDelete(data:IListIngredient){
    this.ingredients.splice(data.id,1);
  }
  private findAndUpdate(data:IListIngredient){
    this.ingredients.splice(data.id,1, data.ingredient);
  }
  addIngredient(){
    this.ingredients.push(this.ingredientField);
    this.ingredientField = "";
  }
}
