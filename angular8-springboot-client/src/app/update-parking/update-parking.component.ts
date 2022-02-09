import { Component, OnInit } from '@angular/core';
import { Parking } from '../parking';
import { ActivatedRoute, Router } from '@angular/router';
import { ParkingService } from '../parking.service';

@Component({
  selector: 'app-update-parking',
  templateUrl: './update-parking.component.html',
  styleUrls: ['./update-parking.component.css']
})
export class UpdateParkingComponent implements OnInit {

  id: number;
  parking: Parking;

  constructor(private route: ActivatedRoute,private router: Router,
    private parkingService: ParkingService) { }

  ngOnInit() {
    this.parking = new Parking();

    this.id = this.route.snapshot.params['id'];
    
    this.parkingService.getParking(this.id)
      .subscribe(data => {
        console.log(data)
        this.parking = data;
      }, error => console.log(error));
  }

  updateParking(){
    this.parkingService.updateParking(this.id,this.parking)
      .subscribe(data => console.log(data), error => console.log(error));
      this.parking = new Parking();
      this.gotoList();
     
  }

  onSubmit() {
    this.updateParking();    
  }

  gotoList() {
    this.router.navigate(['/parkings']);
  }
}
