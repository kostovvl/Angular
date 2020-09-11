import { Component, OnInit } from '@angular/core';
import Movie from '../model/movie.model';
import { MoviesService } from '../service/movies.service';

@Component({
  selector: 'app-jumbotron',
  templateUrl: './jumbotron.component.html',
  styleUrls: ['./jumbotron.component.css']
})
export class JumbotronComponent implements OnInit {

  foundMovies: Movie[];
  length: number = null;

  constructor(private moivesService: MoviesService) { }

  ngOnInit(): void {
  }

  search(title: string) {
    this.moivesService.getByTitle(title).subscribe(
      data => {
        this.foundMovies = data;
        this.length = this.foundMovies.length;
      }
    )
  }

}
