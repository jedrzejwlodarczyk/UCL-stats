import { Component, OnInit, inject, ChangeDetectorRef } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ActivatedRoute, RouterLink } from "@angular/router";
import { PlayerService } from "../../services/player.service";
import { Player } from "../../models/player.model";
import { Router } from "@angular/router";

@Component({
    selector: 'app-player-list',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './player-list.component.html',
    styleUrl: './player-list.component.css'
})

export class PlayerListComponent implements OnInit{
    private cdr = inject(ChangeDetectorRef)
    private route = inject(ActivatedRoute);
    private router = inject(Router);
    private playerService = inject(PlayerService);

    players: Player[] = [];

    ngOnInit(): void {
        const teamId = Number(this.route.snapshot.paramMap.get('teamId'));

        if(teamId){
            this.playerService.getPlayersByTeam(teamId).subscribe(data => {
                console.log("Dane ", data);
                this.players = data;

                this.cdr.detectChanges();
            });
        }
    }

    getPlayersByPosition(pos: string): Player[]{
        return this.players.filter(p => p.fieldPosition === pos);
    }

    onPlayerClick(player: any): void {
        this.router.navigate(['/stats', player.idPlayer], {
            state: player
        });
    }
}