import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { AppRoutingModule } from "./app-routing.module";
import { UsersComponent } from "./users/users.component";
import { RolesComponent } from "./roles/roles.component";
import { HomeComponent } from "./home/home.component";
import { AppComponent } from "./app.component";

import { MatTableModule } from "@angular/material";

@NgModule({
  declarations: [AppComponent, UsersComponent, RolesComponent, HomeComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatTableModule,
    FormsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
