import { inject, Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Team } from "../models/team.model";

@Injectable({
    providedIn: 'root'
})

export class TeamService{
    private apiUrl = 'http://localhost:8080/api/v1/teams';
    private http = inject(HttpClient);

    getAllTeams(): Observable<Team[]> {
        return this.http.get<Team[]>(this.apiUrl);
    }
}

