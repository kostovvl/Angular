import { Component, OnInit } from '@angular/core';
import MovieDetails from '../model/movie.details';
import { MovieService } from '../service/movie.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  currentMovie: MovieDetails;



  constructor(public movieService: MovieService, 
    public route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
     this.movieService.getDetails(id).subscribe(data => {
       this.currentMovie = data;
     })

  }

}
