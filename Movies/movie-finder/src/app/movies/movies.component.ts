import { Component, OnInit } from '@angular/core';
import { MoviesService } from '../service/movies.service';
import Movie from '../models/Movie';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

 popularMovies: Movie[];
 topRatedMovies: Movie[];
 clickedId: string = null;

  constructor(private movieService : MoviesService) { }

  ngOnInit(): void {
     this.movieService.getPopular().subscribe(data => {
       this.popularMovies = data.slice(0, 6);
     });

     this.movieService.getInTheaters().subscribe(data => {
      this.topRatedMovies = data.slice(0, 6);
    });

    }

    printNumber(event) {
      this.clickedId = event;
      console.log(event);
    }

}
