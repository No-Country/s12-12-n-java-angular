import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { IRepositoryEmit, IRepositoryRes } from 'src/app/interfaces/repository.interface';
import { RecipeService } from 'src/app/services/recipe.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-my-recipe-card',
  templateUrl: './my-recipe-card.component.html',
  styleUrls: ['./my-recipe-card.component.scss']
})
export class MyRecipeCardComponent {
  @Input() data!: IRepositoryRes;
  @Output() emitRecipe = new EventEmitter<IRepositoryEmit>();

  isCheck = false;
  showDropdown = false;
  constructor(
    private router: Router,
    private recipeServ:RecipeService
  ) { }

  deleteRecipe(id:number){
    this.recipeServ.deleteRecipeById(id).subscribe({
      next:()=>{
        Swal.fire({
          title: "Borrado exitoso",
          icon: "success"
        });
      }
    })
  }

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

  sendRecipe(){
    this.isCheck = !this.isCheck;
    const data = {...this.data, actions:this.isCheck?"add":"delete"}
    this.emitRecipe.emit(data);
  }
}
