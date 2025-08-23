import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Food } from '../../interfaces/food';
import { FoodService } from '../../services/foodservice';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-foodcomp',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  templateUrl: './foodcomp.html',
  styleUrls: ['./foodcomp.css']
})
export class Foodcomp implements OnInit {

  foods: Food[] = [];

  constructor(
    private foodService: FoodService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadFoods();
  }

  loadFoods(): void {
    this.foodService.getAllFoods().subscribe({
      next: (data) => {
        console.log('Foods from backend:', data);
        this.foods = data;
        // force UI update
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error fetching foods:', err)
    });
  }

  buyFood(food: Food): void {
    alert(`You selected to BUY: ${food.name} for ₹${food.price}`);
  }

  orderFood(food: Food): void {
    alert(`You selected to ORDER: ${food.name}`);
  }

  deleteFood(id: number): void {
    if (confirm('Are you sure you want to delete this item?')) {
      this.foodService.deleteFood(id).subscribe(() => {
        this.loadFoods(); 
      });
    }
  }
}
