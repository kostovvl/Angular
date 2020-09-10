import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import Movie from '../model/movie'
import MovieDetails from '../model/movie.details';

const POPUPLAR_URL = 'http://localhost:8080/popular';
const TOP_RATED_URL = 'http://localhost:8080/top_rated'
const NOW_PLAYING_URL = 'http://localhost:8080/popular';
const UPCOMING_URL = 'http://localhost:8080/top_rated'
const DETAILS_URL = 'http://localhost:8080/details/'

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(public http: HttpClient) { }


getPopular() {
  return this.http.get<Movie[]>(POPUPLAR_URL);
}

getTopRated() {
  return this.http.get<Movie[]>(TOP_RATED_URL);
}

getNowPlaying() {
  return this.http.get<Movie[]>(NOW_PLAYING_URL);
}

getUpcoming() {
  return this.http.get<Movie[]>(POPUPLAR_URL);
}

getDetails(id: number) {
  return this.http.get<MovieDetails>(DETAILS_URL + id)
}

}
