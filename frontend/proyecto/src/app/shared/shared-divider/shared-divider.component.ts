import { Component } from '@angular/core';

@Component({
  selector: 'shared-divider',
  template: `
  <div class=divider></div>
  `,
  styles: [`
    .divider{
          background-color: #ABABAB;
          height: 30px;
          width: 1px;
    }
    /* @media screen and (min-width: 767px) {
       .divider{
          display:none;
       }
    } */
  `]
})
export class SharedDividerComponent {

}
