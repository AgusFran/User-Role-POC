import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { tap, catchError } from "rxjs/operators";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Role } from "src/classes/role";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};
const apiUrl = "http://localhost:8080/roles";

@Injectable({
  providedIn: "root"
})
export class RolesService {
  constructor(private http: HttpClient) {}

  private handleError<T>(operation = "operation", result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getRoles(): Observable<Role[]> {
    return this.http
      .get<Role[]>(apiUrl, {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": ["GET", "POST", "PUT", "DELETE"],
          "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
        }
      })
      .pipe(
        tap(roles => console.log("fetched roles")),
        catchError(this.handleError("getRoles", []))
      );
  }
}
