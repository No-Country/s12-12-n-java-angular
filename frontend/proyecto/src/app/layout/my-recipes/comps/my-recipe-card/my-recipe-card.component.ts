import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-recipe-card',
  templateUrl: './my-recipe-card.component.html',
  styleUrls: ['./my-recipe-card.component.scss']
})
export class MyRecipeCardComponent {
  @Input() recipeCommunity: boolean = true;
  isCheck = false;
  showDropdown = false;
  constructor(
    private router: Router
  ) { }
  toDetail() {
    this.router.navigate(['recipes/recipe-details'])
  }
  toEdit() {
    this.router.navigate(['editrecipe'])
  }
  toggleDropdown() {
    this.showDropdown = !this.showDropdown;
    console.log('showDropdown', this.showDropdown);
  }

}
