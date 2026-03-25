import { inject, Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { forkJoin, Observable, map } from "rxjs";
import { PlayerStats, 
    AttackStats, 
    DefenseStats, 
    AttemptsStats, 
    DisciplinaryStats, 
    GoalsStats, 
    KeyStats, 
    DistributionStats,
    GoalkeepingStats } from "../models/playerstats";

@Injectable({
    providedIn: 'root'
})

export class PlayerStatsService{
    private http = inject(HttpClient);
    private baseUrl = 'http://localhost:8080/api/v1';

    getFullPlayerStats(idPlayer: number): Observable<PlayerStats>{
        return forkJoin({
            attack: this.http.get<AttackStats>(`${this.baseUrl}/attacking-data/player/${idPlayer}`),
            attemps: this.http.get<AttemptsStats>(`${this.baseUrl}/attempts/player/${idPlayer}`),
            defense: this.http.get<DefenseStats>(`${this.baseUrl}/defending/player/${idPlayer}`),
            disciplinary: this.http.get<DisciplinaryStats>(`${this.baseUrl}/disciplinary/player/${idPlayer}`),
            goals: this.http.get<GoalsStats>(`${this.baseUrl}/goals/player/${idPlayer}`),
            key: this.http.get<KeyStats>(`${this.baseUrl}/key-stats/player/${idPlayer}`),
            distribution: this.http.get<DistributionStats>(`${this.baseUrl}/distribution/player/${idPlayer}`),
            goalkeeping: this.http.get<GoalkeepingStats>(`${this.baseUrl}/goalkeeping/player/${idPlayer}`)
        }).pipe(
            map(data => {
                const stats: PlayerStats = {
                    playerName: data.attack.name,
                    attack: data.attack,
                    attempts: data.attemps,
                    defense: data.defense,
                    disciplinary: data.disciplinary,
                    goals: data.goals,
                    key: data.key,
                    distribution: data.distribution,
                    goalkeeping: data.goalkeeping
                };
                return stats;
            })
        );
    }

    getTopPlayersByStat(category: string, subcategory: string, size: number): Observable<PlayerStats[]>{
        return this.http.get<PlayerStats[]>(`${this.baseUrl}/${category}/${subcategory}`);
    }

}