import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { UsersComponent } from "./users/users.component";
import { RolesComponent } from "./roles/roles.component";

const routes: Routes = [
  { path: "", redirectTo: "/home", pathMatch: "full" },
  { path: "home", component: HomeComponent, data: { title: "List of Products" } },
  { path: "users", component: UsersComponent, data: { title: "List of Products" } },
  { path: "roles", component: RolesComponent, data: { title: "List of Products" } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
