import { Injectable, } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from '../../../node_modules/rxjs'
import  Movie  from '../models/Movie'

const POPULAR_URL = 'http://localhost:8080/popular';
const IN_THEATER_URL = 'http://localhost:8080/top_rated';


@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  constructor(private http: HttpClient) { }

  getPopular(): Observable<Movie[]> {
   return this.http.get<Movie[]>(POPULAR_URL);
  }

  getInTheaters(): Observable<Movie[]> {
    return this.http.get<Movie[]>(IN_THEATER_URL);
}
}

