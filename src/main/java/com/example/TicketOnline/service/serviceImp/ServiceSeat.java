package com.example.TicketOnline.service.serviceImp;

import com.example.TicketOnline.Entities.Cinema;
import com.example.TicketOnline.Entities.Seat;
import com.example.TicketOnline.repositories.CinemaRepository;
import com.example.TicketOnline.repositories.SeatRepository;
import com.example.TicketOnline.service.IServiceSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSeat implements IServiceSeat<Seat> {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    CinemaRepository cinemaRepository;


    @Override
    public void add(int idCinema) throws Exception {
        Cinema c = cinemaRepository.findById(idCinema).orElseThrow();

        int capacity = c.getSeatAvailable();

        int seatNumber = 1; // tiene traccia di quanti posti hai creato fino ad ora

        for (char letter = 'A'; seatNumber <= capacity; letter++) {
            for (int number = 1; number <= 10 && seatNumber <= capacity; number++) {
                String codeSeat = letter + Integer.toString(number);
                Seat seat = new Seat();
                seat.setCinemaSeat(c);
                seat.setNameSeat(codeSeat);
                seatRepository.save(seat);
                seatNumber++;
            }
        }
    }
        /*
        come funziona il ciclo? parto da 'A' seat number mi tiene traccia di quanti posti ho creato sino ad ora
        il secondo ciclo mi crea i posti della lettera corrispondente fino ad il numero 10, guardando sempre che non
        superi la capienza massima  che imposti
        quindi ipotizzando che A arriva ad a 10, quando va per l'iterazione successiva essendo 11 > 10 esce dal ciclo interno
        permettendo l'incremento alla lettera B e seatNumber sara' uguale a 10 e cosi via..
         */
}
