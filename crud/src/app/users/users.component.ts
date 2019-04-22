import { Component, OnInit } from "@angular/core";
import { User } from "src/classes/user";
import { UsersService } from "src/services/users.service";
import { Role } from "src/classes/role";

@Component({
  selector: "app-users",
  templateUrl: "./users.component.html",
  styleUrls: ["./users.component.scss"]
})
export class UsersComponent implements OnInit {
  users: User[];
  displayedColumns: string[] = ["username", "roles"];

  constructor(private service: UsersService) {
    let roles: Role[] = [new Role("admin"), new Role("admin")];

    this.users = [new User("Asd", "asd", roles), new User("das", "das", roles)];
  }

  ngOnInit() {}
}
