import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-my-recipe-card',
  templateUrl: './my-recipe-card.component.html',
  styleUrls: ['./my-recipe-card.component.scss']
})
export class MyRecipeCardComponent {
  @Input() recipeCommunity:boolean = true;
  isCheck = false;
}
