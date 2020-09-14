
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import Movie from '../model/movie.model';
import MovieDetails from '../model/movie.details';

const POULAR_URL = 'http://localhost:8080/popular'
const TOP_RATED_URL = 'http://localhost:8080/top_rated'
const NOW_PLAYING_URL = 'http://localhost:8080/now_playing'
const UPCOMING_URL = 'http://localhost:8080/upcoming'


const DETAILS_URL = 'http://localhost:8080/details/'
const SEARCH_URL = 'http://localhost:8080/search/'

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

  getTopRatedMovies() {
    return this.httpClient.get<Movie[]>(TOP_RATED_URL);
  }

  getNowPlayingMovies() {
    return this.httpClient.get<Movie[]>(NOW_PLAYING_URL);
  }

  getUpcoming() {
    return this.httpClient.get<Movie[]>(UPCOMING_URL);
  }


  getDetails(id: number) {
    return this.httpClient.get<MovieDetails>(DETAILS_URL + id);
  }

  getByTitle(title: string) {
    return this.httpClient.get<Movie[]>(SEARCH_URL + title.search);
  }
}
