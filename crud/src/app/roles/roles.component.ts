import { Component, OnInit } from "@angular/core";
import { Role } from "src/classes/role";
import { RolesService } from "src/services/roles.service";

@Component({
  selector: "app-roles",
  templateUrl: "./roles.component.html",
  styleUrls: ["./roles.component.scss"]
})
export class RolesComponent implements OnInit {
  roles: Role[];

  constructor(private service: RolesService) {
    this.roles = [new Role("admin")];

    // service.getRoles().subscribe(response => (this.roles = response));
  }

  ngOnInit() {}
}
