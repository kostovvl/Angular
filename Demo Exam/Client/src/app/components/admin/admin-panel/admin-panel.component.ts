import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/core/service/admin.service'

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  form;

  constructor(
    private fb: FormBuilder,
    private adminService: AdminService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', Validators.required]
    })
  }

  get f() {
    return this.form.controls;
  }

  submit() {
    this.adminService.createCategory(this.form.value)
    .subscribe(data => {
      this.router.navigate([ '/home' ])
    })
  }

}
