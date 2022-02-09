import { ParkingDetailsComponent } from '../parking-details/parking-details.component';
import { Observable } from "rxjs";
import { ParkingService } from "../parking.service";
import { Parking } from "../parking";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-parking-list",
  templateUrl: "./parking-list.component.html",
  styleUrls: ["./parking-list.component.css"]
})
export class ParkingListComponent implements OnInit {
  parkings: Observable<Parking[]>;
  

  constructor(private parkingService: ParkingService,
    private router: Router) {}


  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.parkings= this.parkingService.getParkingList();
    }

  deleteParking(id: number) {
    this.parkingService.deleteParking(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  parkingDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateParking(id: number){
    this.router.navigate(['update', id]);
  }
}
