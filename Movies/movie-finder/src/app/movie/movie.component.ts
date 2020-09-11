import { Component, OnInit, Input } from '@angular/core';
import Movie from '../model/movie.model';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  @Input('movie')movie: Movie;
  

  constructor() {
    
   }

  ngOnInit(): void {
  }

}
