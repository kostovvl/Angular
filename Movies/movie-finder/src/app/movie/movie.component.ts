import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import Movie from '../models/Movie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  @Input('movie') movie: Movie
  IMAGE_URL: string;
  @Output('eventEmitter') eventEmitter: EventEmitter<number> = new EventEmitter<number>();

  constructor()  {}

  ngOnInit(): void {
    this.IMAGE_URL = 'http://image.tmdb.org/t/p/w500/' + this.movie.poster_path;
  }

  onClick() {
    const iD = this.movie.id;
     this.eventEmitter.emit(iD);
  }

}
