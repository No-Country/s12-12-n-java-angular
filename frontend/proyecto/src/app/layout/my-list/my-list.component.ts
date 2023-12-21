import { Component, ElementRef, QueryList, ViewChild, ViewChildren } from '@angular/core';
import html2canvas  from 'html2canvas';
import Swal from 'sweetalert2';
import { DATA } from './data';
import { IListDTO } from 'src/app/interfaces/list.interface';

@Component({
  selector: 'app-my-list',
  templateUrl: './my-list.component.html',
  styleUrls: ['./my-list.component.scss']
})
export class MyListComponent {
  @ViewChild("list", {static:false}) list!:ElementRef;
  @ViewChildren('btnDelete , btnExport') btns!: QueryList<ElementRef>

  data:IListDTO[] = DATA.map(({createdAt,ingredients, recipes, message})=>({
    createdAt:new Date(createdAt),
    ingredients,
    recipes,
    message
  }));

  currentListIndex = 0
  currentList = this.data[0];

  changeCurrentList(id:number){
    this.currentListIndex = id;
    this.currentList = this.data[id];
  }

  deleteList(){
    this.data.splice(this.currentListIndex,1)
    this.currentList=this.data[0]
  }

  takeScreenshot(){
    const listIgnore = this.btns.toArray().map(el=>el.nativeElement);
    const options = {
      ignoreElements:(el:Element)=>{
        return listIgnore.includes(el)
      },
    }
    const currentList = this.list.nativeElement;
    html2canvas(currentList, options).then(canvas=>{
      const image = canvas.toDataURL('image/jpg');
      this.downloadScreenshot(image)
      Swal.fire({
        title:"Captura exitosa",
        text:"Revisa tu carpeta de descargas",
        icon:"success"
      })
    })
  }
  private downloadScreenshot(image:string){
    const a = document.createElement('a');
    a.href = image;
    a.download = 'lista.jpg';
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
  }
}
