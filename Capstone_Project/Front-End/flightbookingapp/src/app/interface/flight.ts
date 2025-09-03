export interface Flight {
  id: number;
  flightNumber: string;
  source: string;
  destination: string;
  aircraftName: string;
  airline: string; 
  price: number;
  validFrom?: string; 
  validTo?: string; 
  departureTime?: string; 
  arrivalTime?: string;

}

