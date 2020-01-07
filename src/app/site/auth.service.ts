import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
    userName: string = "anonymous";
    logged: boolean = false;
    isAnonymous: boolean = false;

    private authenticationUrl= environment.baseUrl+"/authentication-service/truyum/authenticate";
    private token: string;
    private role: string;

    constructor(private httpClient:HttpClient) { }
  
    authenticate(user:string,password:string):Observable<any>{
    
      let credentials = btoa(user+":"+password);
      let headers = new HttpHeaders();
      headers = headers.set('Authorization','Basic ' + credentials);
      return this.httpClient.get(this.authenticationUrl,{headers});
    
    }
  
    public getToken():string {
      return this.token;
    }
    
    public setToken(token:string) {
      this.token = token;
    }

    public getRole():string {
      return this.role;
    }
    
    public setRole(role:string) {
      this.role = role;
    }

    logIn() {
      this.logged = true;
    }

    logOut() {
      this.logged = false;
      this.userName = "anonymous";   
    }

    isLoggedIn() {
      return this.logged;
    }

    getUserList(userRoleName) {
      this.userName = userRoleName;
    }

    anonymousUserStatus(userStatus){
      this.isAnonymous = userStatus;
    }
}
