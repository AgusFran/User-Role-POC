import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { UsersComponent } from "./users/users.component";
import { RolesComponent } from "./roles/roles.component";
import { HomeComponent } from "./home/home.component";
import { AppComponent } from "./app.component";

@NgModule({
  declarations: [AppComponent, UsersComponent, RolesComponent, HomeComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
