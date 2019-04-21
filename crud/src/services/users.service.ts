import { Injectable } from "@angular/core";
import { Observable, of, throwError } from "rxjs";
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { catchError, tap, map } from "rxjs/operators";
import { User } from "src/classes/user";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};
const apiUrl = "http://localhost:8080/users";

@Injectable({
  providedIn: "root"
})
export class UsersService {
  constructor(private http: HttpClient) {}

  private handleError<T>(operation = "operation", result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getUsers(): Observable<User[]> {
    return this.http
      .get<User[]>(apiUrl, {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": ["GET", "POST", "PUT", "DELETE"],
          "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
        }
      })
      .pipe(
        tap(roles => console.log("fetched users")),
        catchError(this.handleError("getUsers", []))
      );
  }
}
