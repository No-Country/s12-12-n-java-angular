import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  public showMenu: boolean = false;



  toggleMenu() {
    console.log('toggleMenu abierto');
    this.showMenu = !this.showMenu;
  }
  closeMenu() {
    this.showMenu = false;
  }
}
