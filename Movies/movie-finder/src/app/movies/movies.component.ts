import { Component, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';
import Movie from '../model/movie';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  popular: Movie[];
  topRated: Movie[];
  iD: number = null;

  constructor(public movieService: MovieService) {
    
   }

  ngOnInit(): void {
    this.movieService.getPopular().subscribe(data => {
      this.popular = data.slice(0, 6);
    })
    this.movieService.getTopRated().subscribe(data => {
      this.topRated = data.slice(0, 6);
    })
  }

  showId(event) {
    this.iD = event;
  }

}
