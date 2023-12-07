import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-select-ingredients',
  templateUrl: './select-ingredients.component.html',
  styleUrls: ['./select-ingredients.component.scss']
})
export class SelectIngredientsComponent {
  constructor(
    private router:Router){}

  toIngredients(){
    this.router.navigate(['createlist'])
  }
}
