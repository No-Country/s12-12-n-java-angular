import { Component } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
})
export class UserComponent {
  username = 'Juanito'; //prueba de username
  imageUrl = 'https://this-is-an-invalid-url.com/invalid-image.jpg'; //prueba de imagen que no carga
  imageError = false;

  onImageError() {
    this.imageError = true;
    console.log('La función onImageError se ha ejecutado.');
  }
}
