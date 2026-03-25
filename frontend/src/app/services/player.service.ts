import { inject, Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Player } from "../models/player.model";

@Injectable({
    providedIn: 'root'
})

export class PlayerService{
    private http = inject(HttpClient);
    private apiUrl = 'http://localhost:8080/api/v1/players/team';

    getPlayersByTeam(teamId: number): Observable<Player[]>{
        return this.http.get<Player[]>(`${this.apiUrl}/${teamId}`);
    }
}