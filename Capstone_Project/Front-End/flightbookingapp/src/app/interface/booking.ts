import { PaymentStatus } from "../../paymentstatus";
export interface IBooking {
  id: number;             
  flightId: number;
  passengerName: string;
  email: string;
  amount: number;
  cardNumber?: string;
  bookingTime?: string;
  status?: PaymentStatus; 
}
