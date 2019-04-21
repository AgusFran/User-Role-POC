import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent {
  title = "crud";
  sections: string[] = ["users", "roles"];

  redirect(route: string) {
    console.log("asd");
  }
}
