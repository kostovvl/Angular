import { Component, OnInit } from '@angular/core';
import Movie from '../model/movie.model';
import { MoviesService } from '../service/movies.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  constructor(private moivesService: MoviesService) { }

  popularMovies : Movie[];

  ngOnInit(): void {
    this.moivesService.getPopularMovies().subscribe(data => {
      this.popularMovies = data.slice(0, 6);
    })
  }

}
