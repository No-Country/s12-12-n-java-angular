import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout.component';

const routes: Routes = [
  {
    path: '', component: LayoutComponent, children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomeModule) },
      { path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule) },
      { path: 'register', loadChildren: () => import('./register/register.module').then(m => m.RegisterModule) },
      { path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomeModule) },
      { path: 'recipes', loadChildren: () => import('./recipes/recipes.module').then(m => m.RecipesModule) },
      { path: 'recipes/recipe-details', loadChildren: () => import('./recipe-details/recipe-details.module').then(m => m.RecipeDetailsModule) },
      { path: 'mylist', loadChildren: () => import('./my-list/my-list.module').then(m => m.MyListModule) },
      { path: 'user', loadChildren: () => import('./user/user.module').then(m => m.UserModule) },
      { path: 'myrecipes', loadChildren: () => import('./my-recipes/my-recipes.module').then(m => m.MyRecipesModule) },
      { path: 'selectingredients', loadChildren: () => import('./select-ingredients/select-ingredients.module').then(m => m.SelectIngredientsModule) },
      { path: 'createlist', loadChildren: () => import('./create-list/create-list.module').then(m => m.CreateListModule) },
      { path: 'createrecipe', loadChildren: () => import('./create-recipe/create-recipe.module').then(m => m.CreateRecipeModule) },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
