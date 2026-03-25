import { Routes } from '@angular/router';
import { TeamListComponent } from './components/team-list/team-list.component';
import { PlayerListComponent } from './components/player-list/player-list.component';
import { PlayerStatsComponent } from './components/player-stats/player-stats.component';

export const routes: Routes = [
    { path: '', component: TeamListComponent},
    { path: 'players/:teamId', component: PlayerListComponent},
    { path: 'stats/:idPlayer', component: PlayerStatsComponent}
];
