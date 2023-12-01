import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  constructor(
    private route:Router
  ){}
  redirectFromHome(){
    /* logica para detectar si hay un token en las cookies */
    const token = true
    if(token){
      this.route.navigate(['recipes'])
    }
    else{
      this.route.navigate(['login'])
    }
  }
}
