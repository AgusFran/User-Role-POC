import { Role } from "./role";

export class User {
  private username: string;
  private password: string;
  private roles: Role[];

  constructor(username: string, password: string, roles: Role[]) {
    this.username = username;
    this.password = password;
    this.roles = roles;
  }
}
