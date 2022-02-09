import { Parking } from '../parking';
import { Component, OnInit, Input } from '@angular/core';
import { ParkingService } from '../parking.service';
import { ParkingListComponent } from '../parking-list/parking-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-parking-details',
  templateUrl: './parking-details.component.html',
  styleUrls: ['./parking-details.component.css']
})
export class ParkingDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['parkings']);
  }
}
