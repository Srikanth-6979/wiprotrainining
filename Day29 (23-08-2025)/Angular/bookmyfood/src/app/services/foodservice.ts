import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Food } from '../interfaces/food';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private baseUrl = 'http://localhost:9090/api/foods';

  constructor(private http: HttpClient) {}

  getAllFoods(): Observable<Food[]> {
    return this.http.get<Food[]>(this.baseUrl);
  }

  addFood(food: Food): Observable<Food> {
    return this.http.post<Food>(this.baseUrl, food);
  }

  updateFood(id: number, food: Food): Observable<Food> {
    return this.http.put<Food>(`${this.baseUrl}/${id}`, food);
  }

  deleteFood(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
