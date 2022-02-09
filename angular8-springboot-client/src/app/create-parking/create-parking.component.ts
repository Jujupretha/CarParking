import { ParkingService } from '../parking.service';
import { Parking } from '../parking';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-parking',
  templateUrl: './create-parking.component.html',
  styleUrls: ['./create-parking.component.css']
})
export class CreateParkingComponent implements OnInit {

  parking: Parking = new Parking();
  submitted = false;
  //Parking: Parking;

  constructor(private parkingService: ParkingService,
    private router: Router) { }

  ngOnInit() {
  }

  newParking(): void {
    this.submitted = false;
    this.parking = new Parking();
  }

//   save() {
//     this.parkingService
// .createParking(this.parking).subscribe(data => {
//       console.log(data)
//       this.parking = new Parking();
//       this.gotoList();
//     }, 
//     error => console.log(error));
//   }

save(){
  this.parkingService.createParking(this.parking)
    .subscribe(data => console.log(data), error => console.log(error));
    this.parking = new Parking();
    this.gotoList();
}

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/parkings']);
  }
}
