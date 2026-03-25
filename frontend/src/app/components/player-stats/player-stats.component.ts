import { Router } from "@angular/router";
import { ChangeDetectorRef, Component, OnInit, inject } from "@angular/core";
import { PlayerStats } from "../../models/playerstats";
import { PlayerStatsService } from "../../services/playerstats.service";
import { CommonModule } from "@angular/common";
import { ActivatedRoute, RouterLink } from "@angular/router";

@Component({
    selector: 'app-player-stats',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './player-stats.component.html',
    styleUrl: './player-stats.component.css'
})

export class PlayerStatsComponent implements OnInit{
    private route = inject(ActivatedRoute);
    private playerStatsService = inject(PlayerStatsService);
    private router = inject(Router);
    private cdr = inject(ChangeDetectorRef);

    stats: PlayerStats | null = null;
    playerImage: string | null = null;
    playerData: any = null;
    activeTab: 'main' | 'attacking' | 'defense' | 'distribution' | 'disciplinary' | 'attempts' | 'goals' = 'main';

    constructor(){
        const navigation = this.router.getCurrentNavigation();
        if (navigation?.extras?.state) {
    this.playerData = navigation.extras.state;
}
    }

    ngOnInit(): void {
        const idPlayer = Number(this.route.snapshot.paramMap.get('idPlayer'));

        this.playerStatsService.getFullPlayerStats(idPlayer).subscribe(data => {
            this.stats = data;
            this.cdr.detectChanges();
        })
    }
}