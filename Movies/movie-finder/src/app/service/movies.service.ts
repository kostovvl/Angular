import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import Movie from '../model/movie.model';

const POULAR_URL = 'http://localhost:8080/popular'

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

}
