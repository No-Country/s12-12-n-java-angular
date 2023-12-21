import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IIngredientCheck } from 'src/app/interfaces/ingredient.interface';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.scss']
})
export class ItemListComponent {
  @Input() ingredientCheck !: IIngredientCheck;
  @Output() emitIngredient = new EventEmitter<IIngredientCheck>();

  sendIngredient(){
    const { isCheck } = this.ingredientCheck
    const data:IIngredientCheck = {
      ...this.ingredientCheck,
      isCheck:!isCheck
    }
    this.emitIngredient.emit(data);
  }
}
