package it.alten.game.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemInRoomDto extends ItemDto{

    private int room_id;
}
