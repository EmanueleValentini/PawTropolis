package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.RoomConnection;
import it.alten.game.model.enums.Direction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component("go")
public class GoCommand extends ParametrizedCommand {

    @Autowired
    public GoCommand(GameController gameController) {
        super(gameController);
    }

    public GoCommand(GameController gameController, List<String> parameters) {
        super(gameController, parameters);
    }

    @Override
    public void execute() {
        Direction direction = Direction.of(String.join(" ", parameters));
        Player player = gameController.getPlayerController().findById(1);
        Room currentRoom = gameController.getRoomController().findById(player.getRoom().getId());
        RoomConnection roomConnection = gameController.getRoomConnectionController().findByCurrentRoomAndDirection(currentRoom,direction);
        if (roomConnection != null) {
            Room nextRoom = gameController.getRoomController().findById(roomConnection.getNewRoom().getId());
            gameController.getPlayerController().updatePlayerRoom(nextRoom);
            System.out.println("Stai in " + gameController.getPlayerController().findById(1).getRoom().getName());
        } else {
            System.out.println("Nun ce poi annà");
        }
    }
}
