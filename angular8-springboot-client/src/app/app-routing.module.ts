import { ParkingDetailsComponent } from './parking-details/parking-details.component';
import { CreateParkingComponent } from './create-parking/create-parking.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ParkingListComponent } from './parking-list/parking-list.component';
import { UpdateParkingComponent } from './update-parking/update-parking.component';

const routes: Routes = [
  { path: '', redirectTo: 'parking', pathMatch: 'full' },
  { path: 'parkings', component: ParkingListComponent },
  { path: 'add', component: CreateParkingComponent },
  { path: 'update/:id', component: UpdateParkingComponent },
  { path: 'details/:id', component: ParkingDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
