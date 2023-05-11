package it.alten.game;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import it.alten.game.model.CommandFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BeanTest {
    private GameController gameController;

    private RoomController roomController;

    private CommandFactory commandFactory;

    @Autowired
    public void init(GameController gameController, RoomController roomController, CommandFactory commandFactory) {
        this.gameController = gameController;
        this.roomController = roomController;
        this.commandFactory = commandFactory;
    }

    @Test
    public void testRoomController() {
        assertNotNull(gameController.getRoomController());
    }

    @Test
    public void testGameController() throws Exception {
        assertNotNull(commandFactory.createCommandFromString("go").getGameController());
    }
}
