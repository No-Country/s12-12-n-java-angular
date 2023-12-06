import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipe-card',
  templateUrl: './recipe-card.component.html',
  styleUrls: ['./recipe-card.component.scss']
})
export class RecipeCardComponent {
  constructor(
    private router:Router
  ){}
  toDetail(){
    this.router.navigate(['recipes/recipe-details'])
  }

}
