import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './services/login.service';
import { Login } from './interfaces/login';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  private username: string;
  private password: string;
  private loading: boolean;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {}

  login(): void {
    this.loading = true;

    let login: Login = {
      username: this.username,
      password: this.password,
      redirect: 'sada',
    };

    this.loginService.login(login).subscribe(
      (response) => {
        this.loading = false;
        console.log(response);
        console.log(response.headers.get('Authorization'));
      },
      (error) => {
        this.loading = false;
      },
    );
  }
}
