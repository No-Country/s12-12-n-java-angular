import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
 // password: string;
  hide = true;

  constructor(){}

  passwordVisible() {
    this.hide = !this.hide;
  }

  login(){
    console.log('Funcionando');
  }
}
