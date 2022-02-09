import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateParkingComponent } from './create-parking/create-parking.component';
import { ParkingDetailsComponent } from './parking-details/parking-details.component';
import { ParkingListComponent } from './parking-list/parking-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateParkingComponent } from './update-parking/update-parking.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateParkingComponent,
    ParkingDetailsComponent,
    ParkingListComponent,
    UpdateParkingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
