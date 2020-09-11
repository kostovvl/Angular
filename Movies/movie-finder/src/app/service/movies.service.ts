
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import Movie from '../model/movie.model';
import MovieDetails from '../model/movie.details';

const POULAR_URL = 'http://localhost:8080/popular'
const DETAILS_URL = 'http://localhost:8080/details/'

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(
    private httpClient: HttpClient
  ) { }


  getPopularMovies() {
    return this.httpClient.get<Movie[]>(POULAR_URL);
  }

  getDetails(id: number) {
    return this.httpClient.get<MovieDetails>(DETAILS_URL + id);
  }
}
