import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FurnitureService } from '../furniture.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  form;

  constructor(private fb: FormBuilder,
    private service: FurnitureService,
    private router: Router) { }

  ngOnInit() {
    this.form = this.fb.group({
      make: ['', Validators.required],
      model: ['', Validators.required],
      year: ['',Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      image: ['', Validators.required],
      material: ['', ]
    })
  }

  get f() {
    return this.form.controls;
  }

  submit() {
   if (this.form.valid) {
    this.service.submit(this.form.value)
    .subscribe((data) => {
      this.router.navigate(['furniture/all'])
    })}
  }

}
