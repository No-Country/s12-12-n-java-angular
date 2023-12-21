import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { IrecipeResponse } from 'src/app/interfaces/receta.interface';

@Component({
  selector: 'app-recipe-mini-card',
  templateUrl: './recipe-mini-card.component.html',
  styleUrls: ['./recipe-mini-card.component.scss']
})
export class RecipeMiniCardComponent {
  @Input() miniRecipeData!:IrecipeResponse;
  constructor(
    private route:Router
  ){}
  seeDetails(){
    this.route.navigate(['recipes/recipe-details'])
  }
}
