import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TeamListComponent } from './components/team-list/team-list.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TeamListComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
