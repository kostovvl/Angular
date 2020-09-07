import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import Movie from '../model/movie'

const POPUPLAR_URL = 'http://localhost:8080/popular';
const TOP_RATED_URL = 'http://localhost:8080/top_rated'

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

}
