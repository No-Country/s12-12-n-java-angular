import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IListIngredient } from 'src/app/interfaces/list.interface';

@Component({
  selector: 'app-list-edit',
  templateUrl: './list-edit.component.html',
  styleUrls: ['./list-edit.component.scss']
})
export class ListEditComponent {
  @Input() ingredient = "";
  @Input() id = 0;
  @Output() emitIngredient = new EventEmitter<IListIngredient>()
  isReadonly=true;
  updateIngredient(){
    this.isReadonly = true;
    const data:IListIngredient = {
      id:this.id,
      ingredient:this.ingredient,
      status:"update"
    }

    this.emitIngredient.emit(data)
  }
  deleteIngredient(){
    const data:IListIngredient = {
      id:this.id,
      ingredient:this.ingredient,
      status:"delete"
    }
    this.emitIngredient.emit(data)
  }
}
