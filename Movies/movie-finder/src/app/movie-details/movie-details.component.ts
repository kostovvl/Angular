import { Component, OnInit } from '@angular/core';
import MovieDetails from '../model/movie.details';
import {MoviesService} from '../service/movies.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  movieDetails: MovieDetails;

  constructor(private movieSevice: MoviesService,
    private path: ActivatedRoute) { }

  ngOnInit(): void {
    this.movieSevice.getDetails(this.path.snapshot.params['id'])
    .subscribe(data => {
      this.movieDetails = data;
    } )
  }

}
