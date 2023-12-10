import { Component } from '@angular/core';

@Component({
  selector: 'app-profile-picture',
  templateUrl: './profile-picture.component.html',
  styleUrls: ['./profile-picture.component.scss']
})
export class ProfilePictureComponent {
  username = 'Juanito'; //prueba de username
  imageUrl = 'https://this-is-an-invalid-url.com/invalid-image.jpg'; //prueba de imagen que no carga
  imageError = false;

// agregar loader spinner
  onImageError() {
    this.imageError = true;
    console.log('La función onImageError se ha ejecutado.');
  }
}
