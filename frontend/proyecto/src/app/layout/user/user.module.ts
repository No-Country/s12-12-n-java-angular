import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ProfilePictureComponent } from './profile-picture/profile-picture.component';
import { LogoutYDelAccountComponent } from './logout-y-del-account/logout-y-del-account.component';

import { EditUserComponent } from './edit-user/edit-user.component';

@NgModule({
  declarations: [
    UserComponent,
    ProfilePictureComponent,
    LogoutYDelAccountComponent,
    EditUserComponent,
  ],
  imports: [CommonModule, UserRoutingModule, ReactiveFormsModule],
})
export class UserModule {}
