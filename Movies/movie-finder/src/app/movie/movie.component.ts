import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import Movie from '../model/movie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  @Input('movie') movie: Movie;
  fullImageUrl: string;
  @Output('eventEmitter')
  eventEmitter: EventEmitter<number>;

  constructor() { 
    this.eventEmitter = new EventEmitter<number>();
  }

  ngOnInit(): void {
    this.fullImageUrl = 'https://image.tmdb.org/t/p/w500/' + this.movie.imageURL;
  }

}
