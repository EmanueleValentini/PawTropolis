package it.alten.game.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ItemInBagDto extends ItemDto{

    private int idBag;
}
