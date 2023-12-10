import { Component, HostListener, inject } from '@angular/core';
import { Router } from '@angular/router';
import { navbarData } from '../../shared/navigation/nav-data';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
    public showMenu: boolean = false;
    public scrolled: boolean = false;
    navData = navbarData;
    private router = inject(Router);
    iconCookingWhite = '../../../assets/icons/cook-icon.svg';
    iconCookingBlack = '../../../assets/icons/cook-icon-black.svg';

    @HostListener('window:scroll', ['$event'])
    onScroll(): void {
        if (window.scrollY > 80) {
            this.scrolled = true;
        } else {
            this.scrolled = false;
        }
    }
    /**
     * The function returns a cooking icon based on whether the page has been scrolled or not.
     * @returns a string value. The specific string value being returned depends on the value of the
     * variable "scrolled". If "scrolled" is true, the function returns the value of the variable
     * "iconCookingBlack". If "scrolled" is false, the function returns the value of the variable
     * "iconCookingWhite".
     */
    get iconCooking(): string {
        return this.scrolled ? this.iconCookingBlack : this.iconCookingWhite;
    }
    toggleMenu() {
        console.log('toggleMenu abierto');
        this.showMenu = !this.showMenu;
    }
    closeMenu() {
        this.showMenu = false;
    }

    /*Metodo temporal para ver el usuario */
    userRedirect() {
        this.router.navigate(['user'])
    }
}
