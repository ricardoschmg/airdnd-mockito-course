package com.debuggeandoideas.airdnd.Services;


import com.debuggeandoideas.airdnd.repositories.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomServiceTest {

    private RoomRepository roomRepository;
    private RoomService roomService;

    @BeforeEach
    void init() {
      this.roomRepository = new RoomRepository();
      this.roomService = new RoomService(roomRepository);
    }

    @Test
    @DisplayName("Should get all rows available in room repository")
    void findAllAvailableRooms(){
     var expected = 4;
     var result = this.roomService.findAllAvailableRooms();
     assertEquals(expected,result.size());

    }


}
