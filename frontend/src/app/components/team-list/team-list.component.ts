import { Router } from "@angular/router";
import { ChangeDetectorRef, Component, OnInit, inject } from "@angular/core";
import { TeamService } from "../../services/team.service";
import { Team } from "../../models/team.model";
import { CommonModule } from "@angular/common";
import { Player } from "../../models/player.model";
import { PlayerService } from "../../services/player.service";

@Component({
    selector: 'app-team-list',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './team-list.component.html',
    styleUrl: './team-list.component.css'
})

export class TeamListComponent implements OnInit{
    private cdr = inject(ChangeDetectorRef);
    private router = inject(Router);
    private teamService: TeamService = inject(TeamService);

    teams: Team[] = [];
    
    ngOnInit(): void {
        this.teamService.getAllTeams().subscribe(data => {
            this.teams = data;
            console.table(this.teams)
            this.cdr.detectChanges();
        })
    }

    onTeamClick(teamId: number): void{
        this.router.navigate(['/players', teamId]);
    }

}