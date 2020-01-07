import { Component, OnInit } from '@angular/core';
import { AuthService } from '../site/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService:AuthService,private router: Router) { 
  }

  ngOnInit() {
  }

  getUserRole() {
    return this.authService.userName;
  }

  logOff() {
    this.authService.logOut();
    this.router.navigate([""]);
  }
  
}
