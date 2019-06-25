import { Router, NavigationEnd, NavigationStart } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LayoutService } from './layout.service';
import { OnChanges } from '@angular/core/src/metadata/lifecycle_hooks';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.less']
})
export class SideBarComponent implements OnInit {
  private przekieruj: String;
  isSidebarVisible: number = 0;



  constructor(private layoutService: LayoutService, private router: Router, private loginService: LoginService) {

  }


  ngOnInit() {


    this.layoutService.sidebarSource$.asObservable().subscribe((isVisible) => {
      this.isSidebarVisible = isVisible;
    });

    if (localStorage.getItem('token')) {
      console.log('token')
      if (localStorage.getItem('admin')) {
        console.log('admin')
        this.isSidebarVisible = 2;
        console.log(this.isSidebarVisible)
      } else {
        console.log('user')
        this.isSidebarVisible = 1;
        console.log(this.isSidebarVisible)
      }
    } else {
      this.isSidebarVisible = 0;
    }

  }


  ReDirect(przekieruj) {
    this.router.navigate([przekieruj]);
  }

  Logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('admin');
    console.log('przed');
    this.router.navigate(['']);
    console.log('po');
    this.layoutService.hideSidebar();
  }
  clickMethod() {
    if (confirm('Are you sure to delete account ?')) {
      this.loginService.DeleteAcc().subscribe();
      this.Logout();
    }

  }
  ChangePassword() {
    this.router.navigate(['pass']);

  }

  checkAccounts() {
    this.router.navigate(['accounts']);
    // this.loginService.getAccounts().subscribe();

  }
  search() {
    this.router.navigate(['search']);
  }
  checkCars() {
    this.router.navigate(['']);
  }
}
