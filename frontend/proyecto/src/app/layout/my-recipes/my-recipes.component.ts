import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-recipes',
  templateUrl: './my-recipes.component.html',
  styleUrls: ['./my-recipes.component.scss']
})
export class MyRecipesComponent {
   recipes = [];
  constructor(
    private route:Router
  ){}

  createList(){
    this.route.navigate(['selectingredients'])
  }
}
