package com.debuggeandoideas.airdnd.Services;


import com.debuggeandoideas.airdnd.Services.RoomService;
import com.debuggeandoideas.airdnd.Services.utils.DataDummy;
import com.debuggeandoideas.airdnd.repositories.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    private RoomRepository roomRepositoryMock;
    private RoomService roomService;

    @BeforeEach
    void init() {
      this.roomRepositoryMock = mock(RoomRepository.class);
      this.roomService = new RoomService(roomRepositoryMock);
    }

    @Test
    @DisplayName("Should get all rows available in room repository")
    void findAllAvailableRooms(){
     when(roomRepositoryMock.findAll())
             .thenReturn(DataDummy.default_rooms);
     var expected = 3;
     var result = this.roomService.findAllAvailableRooms();
     assertEquals(expected,result.size());
    }
}
