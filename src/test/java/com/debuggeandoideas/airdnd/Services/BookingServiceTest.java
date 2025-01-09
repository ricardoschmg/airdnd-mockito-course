package com.debuggeandoideas.airdnd.Services;

import com.debuggeandoideas.airdnd.helpers.MailHelper;
import com.debuggeandoideas.airdnd.repositories.BookingRepository;
import org.junit.jupiter.api.Disabled;
import com.debuggeandoideas.airdnd.Services.utils.DataDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private PaymentService paymentServiceMock;
    @Mock
    private RoomService roomServiceMock;
    @Mock
    private BookingRepository bookingRepositoryMock;
    @Mock
    private MailHelper mailHelperMock;
    @InjectMocks
    private BookingService bookingService;

    @Test
    @DisplayName("prueba obtener numero de habitaciones disponibles")
    void getAvailablePlaceCount () {
     when (this.roomServiceMock.findAllAvailableRooms())
             .thenReturn(DataDummy.default_rooms_list);

        var expected = 14;
        var result = this.bookingService.getAvailablePlaceCount();

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("booking should works")
    void booking () {
        final var roomId = UUID.randomUUID().toString();
        when (roomServiceMock.findAvailableRoom(DataDummy.default_booking_req_2)).
                thenReturn(DataDummy.default_rooms_list.get(0));

        when (bookingRepositoryMock.save(DataDummy.default_booking_req_2)).
                 thenReturn(roomId);

        var result = bookingService.booking(DataDummy.default_booking_req_2);

        assertEquals(roomId, result);
    }

}
