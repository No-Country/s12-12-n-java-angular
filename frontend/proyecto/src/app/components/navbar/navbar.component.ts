import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  public showMenu: boolean = false;

  constructor(
    private router:Router
  ){}

  toggleMenu() {
    console.log('toggleMenu abierto');
    this.showMenu = !this.showMenu;
  }
  closeMenu() {
    this.showMenu = false;
  }

  /*Metodo temporal para ver el usuario */
  userRedirect(){
    this.router.navigate(['user'])
  }
}
