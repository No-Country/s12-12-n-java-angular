import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IListDTO } from 'src/app/interfaces/list.interface';

@Component({
  selector: 'app-list-card',
  templateUrl: './list-card.component.html',
  styleUrls: ['./list-card.component.scss']
})
export class ListCardComponent {
  @Input() dataList !: IListDTO;
}
