import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FurnitureService } from '../furniture.service';

@Component({
  selector: 'app-create-furniture',
  templateUrl: './create-furniture.component.html',
  styleUrls: ['./create-furniture.component.css']
})
export class CreateFurnitureComponent implements OnInit {

  form;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private furnitureService: FurnitureService) { }

  ngOnInit() {
    this.form = this.fb.group(
      {make : ['', [Validators.required]],
      model: ['',  [Validators.required]],
      year : ['', [Validators.required]],
      description : ['', [Validators.required]],
      price: ['',  [Validators.required]],
      image : ['', [Validators.required]],
      material : ['', [Validators.nullValidator]],
      }
    )
  }

  get f() {
    return this.form.controls;
  }

  submit() {
    if (this.form.valid) {
      this.furnitureService.createNewFurniture(this.form.value).subscribe(
        data => {
          this.router.navigate(['furniture/all']);
        }
      )
    }
  }
}
