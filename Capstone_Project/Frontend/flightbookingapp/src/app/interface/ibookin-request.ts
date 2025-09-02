export interface IBookingRequest {
  passengerName: string;
  email: string;
  flightId: number;
  amount: number;
  cardNumber?: string; 
}
