import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout-y-del-account',
  templateUrl: './logout-y-del-account.component.html',
  styleUrls: ['./logout-y-del-account.component.scss'],
})
export class LogoutYDelAccountComponent {
  constructor(private router: Router) {}

  /* metodo temporal para ver el login */
  logout() {
    this.router.navigate(['login']);
  }
}
